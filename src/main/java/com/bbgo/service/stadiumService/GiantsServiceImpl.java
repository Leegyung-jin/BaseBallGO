package com.bbgo.service.stadiumService;

import com.bbgo.config.auth.PrincipalDetail;
import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.stadium.*;
import com.bbgo.repository.stadiumRepository.GiantsStadiumImageRepository;
import com.bbgo.repository.stadiumRepository.GiantsStadiumRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GiantsServiceImpl implements GiantsService {

    private final GiantsStadiumRepository repository;
    private final GiantsStadiumImageRepository imageRepository;

    // List
    @Override
    public PageResultDTO<StadiumDTO, GiantsStadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());

        // 검색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<GiantsStadium> result = repository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<GiantsStadium, StadiumDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QGiantsStadium qGiantsStadium = QGiantsStadium.giantsStadium;


        // sno > 0조건 생성
        BooleanExpression expression = qGiantsStadium.sno.gt(0L);
        booleanBuilder.and(expression);


        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("1")) {
            conditionBuilder.or(qGiantsStadium.base.contains("1")).and(qGiantsStadium.section.contains(keyword));
        }
        if (type.contains("2")) {
            conditionBuilder.or(qGiantsStadium.base.contains("2")).and(qGiantsStadium.section.contains(keyword));
        }
        if (type.contains("3")) {
            conditionBuilder.or(qGiantsStadium.base.contains("3")).and(qGiantsStadium.section.contains(keyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;
    }


    @Transactional
    @Override
    public Long register(StadiumDTO stadiumDTO, PrincipalDetail principalDetail) {
        stadiumDTO.setUsername(principalDetail.getUsername());
        stadiumDTO.setName(principalDetail.getName());
        stadiumDTO.setMno(principalDetail.getMno());

        Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
        GiantsStadium stadium = (GiantsStadium) entityMap.get("stadium");
        List<GiantsStadiumImage> stadiumImageList = (List<GiantsStadiumImage>) entityMap.get("imgList");

        repository.save(stadium);

        stadiumImageList.forEach(stadiumImage -> {
            imageRepository.save(stadiumImage);
        });

        return stadium.getSno();
    }

    @Override
    public StadiumDTO getStadium(Long sno) {
        List<Object[]> result = repository.getStadiumWithAll(sno);
        GiantsStadium stadium = (GiantsStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<GiantsStadiumImage> stadiumImageList = new ArrayList<>();    // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            GiantsStadiumImage stadiumImage = (GiantsStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO getModify(long sno) {
        List<Object[]> result = repository.getStadiumWithAll(sno);
        GiantsStadium stadium = (GiantsStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<GiantsStadiumImage> stadiumImageList = new ArrayList<>();          // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            GiantsStadiumImage stadiumImage = (GiantsStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO entitiesToDTO(GiantsStadium stadium, List<GiantsStadiumImage> stadiumImages) {
        return GiantsService.super.entitiesToDTO(stadium, stadiumImages);
    }

    @Override
    public void modify(StadiumDTO stadiumDTO) {

        Optional<GiantsStadium> result = repository.findById(stadiumDTO.getSno());
        if(result.isPresent()){
            GiantsStadium entity = result.get();

            String upperRow = stadiumDTO.getRow().toUpperCase();
            entity.changeRow(upperRow);
            entity.changeNum(stadiumDTO.getNum());
            entity.changeContent(stadiumDTO.getContent());

            repository.save(entity);
            imageRepository.deleteBySno(stadiumDTO.getSno());

            // 이미지
            Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
            List<GiantsStadiumImage> stadiumImageList = (List<GiantsStadiumImage>) entityMap.get("imgList");
            stadiumImageList.forEach(stadiumImage -> {
                imageRepository.save(stadiumImage);
            });
        }
    }

    @Override
    public void delete(Long sno) {
        imageRepository.deleteBySno(sno);
        repository.deleteById(sno);
    }
}