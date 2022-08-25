package com.bbgo.service.stadiumService;

import com.bbgo.config.auth.PrincipalDetail;
import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.stadium.LandersStadium;
import com.bbgo.entity.stadium.LandersStadiumImage;
import com.bbgo.entity.stadium.QLandersStadium;
import com.bbgo.repository.stadiumRepository.LandersStadiumImageRepository;
import com.bbgo.repository.stadiumRepository.LandersStadiumRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class LandersServiceImpl implements LandersService{

    private final LandersStadiumRepository stadiumRepository;
    private final LandersStadiumImageRepository imageRepository;

    @Override
    public PageResultDTO<StadiumDTO, LandersStadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());

        // 검색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<LandersStadium> result = stadiumRepository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<LandersStadium, StadiumDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QLandersStadium qStadium = QLandersStadium.landersStadium;

        // sno > 0조건 생성
        BooleanExpression expression = qStadium.sno.gt(0L);
        booleanBuilder.and(expression);

        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("1")) {
            conditionBuilder.or(qStadium.base.contains("1")).and(qStadium.section.contains(keyword));
        }
        if (type.contains("2")) {
            conditionBuilder.or(qStadium.base.contains("2")).and(qStadium.section.contains(keyword));
        }
        if (type.contains("3")) {
            conditionBuilder.or(qStadium.base.contains("3")).and(qStadium.section.contains(keyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

    // Register
    @Transactional
    @Override
    public Long register(StadiumDTO stadiumDTO, PrincipalDetail principalDetail) {

        stadiumDTO.setUsername(principalDetail.getUsername());
        stadiumDTO.setName(principalDetail.getName());
        stadiumDTO.setMno(principalDetail.getMno());

        Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
        LandersStadium stadium = (LandersStadium) entityMap.get("stadium");
        List<LandersStadiumImage> stadiumImageList = (List<LandersStadiumImage>) entityMap.get("imgList");

        stadiumRepository.save(stadium);

        stadiumImageList.forEach(stadiumImage -> {
            imageRepository.save(stadiumImage);
        });

        return stadium.getSno();
    }

    @Override
    public StadiumDTO getStadium(Long sno) {
        List<Object[]> result = stadiumRepository.getStadiumWithAll(sno);
        LandersStadium stadium = (LandersStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<LandersStadiumImage> stadiumImageList = new ArrayList<>();           // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            LandersStadiumImage stadiumImage = (LandersStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO getModify(long sno, Long mno) {
        List<Object[]> result = stadiumRepository.getStadiumWithAll(sno);
        LandersStadium stadium = (LandersStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<LandersStadiumImage> stadiumImageList = new ArrayList<>();           // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            LandersStadiumImage stadiumImage = (LandersStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO entitiesToDTO(LandersStadium stadium, List<LandersStadiumImage> stadiumImages) {
        return LandersService.super.entitiesToDTO(stadium, stadiumImages);
    }

    @Override
    public void modify(StadiumDTO stadiumDTO) {
        Optional<LandersStadium> result = stadiumRepository.findById(stadiumDTO.getSno());
        if(result.isPresent()){
            LandersStadium entity = result.get();

            String upperRow = stadiumDTO.getRow().toUpperCase();
            entity.changeRow(upperRow);
            entity.changeNum(stadiumDTO.getNum());
            entity.changeContent(stadiumDTO.getContent());

            stadiumRepository.save(entity);
            imageRepository.deleteBySno(stadiumDTO.getSno());

            // 이미지
            Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
            List<LandersStadiumImage> stadiumImageList = (List<LandersStadiumImage>) entityMap.get("imgList");
            if (stadiumImageList.size() > 0) {
                stadiumImageList.forEach(stadiumImage -> {
                    imageRepository.save(stadiumImage);
                });
            }
        }
    }

    @Override
    public void delete(Long sno) {
        imageRepository.deleteBySno(sno);
        stadiumRepository.deleteById(sno);
    }
}