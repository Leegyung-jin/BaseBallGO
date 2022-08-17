package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.dto.team.StadiumImageDTO;
import com.bbgo.entity.QStadium;
import com.bbgo.entity.Stadium;
import com.bbgo.entity.StadiumImage;
import com.bbgo.repository.StadiumImageRepository;
import com.bbgo.repository.StadiumRepository;
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

    // List
    @Override
    public PageResultDTO<StadiumDTO, Stadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());

        // 검색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Stadium> result = stadiumRepository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<Stadium, StadiumDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QStadium qStadium = QStadium.stadium;

        // sno > 0조건 생성
        BooleanExpression expression = qStadium.sno.gt(0L);
        booleanBuilder.and(expression);


        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("1")) {
//            conditionBuilder.or(qStadium.base.contains("1")).and(qStadium.section.contains(keyword));
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
    public Long register(StadiumDTO stadiumDTO) {
        log.info("SI>stadiumDTO: " + stadiumDTO);

        Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
        Stadium stadium = (Stadium) entityMap.get("stadium");
        List<StadiumImage> stadiumImageList = (List<StadiumImage>) entityMap.get("imgList");

        stadiumRepository.save(stadium);

        stadiumImageList.forEach(stadiumImage -> {
            imageRepository.save(stadiumImage);
        });

        return stadium.getSno();
    }

    @Override
    public StadiumDTO getStadium(Long sno) {
        List<Object[]> result = stadiumRepository.getStadiumWithAll(sno);
        Stadium stadium = (Stadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<StadiumImage> stadiumImageList = new ArrayList<>();    // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            StadiumImage stadiumImage = (StadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO entitiesToDTO(Stadium stadium, List<StadiumImage> stadiumImages) {
        System.out.println("================== entitiesToDTO= " + stadium);
        return LandersService.super.entitiesToDTO(stadium, stadiumImages);
    }

    @Override
    public void modify(StadiumDTO stadiumDTO) {
        Optional<Stadium> result = stadiumRepository.findById(stadiumDTO.getSno());
        if(result.isPresent()){
            Stadium entity = result.get();

            entity.changeRow(stadiumDTO.getRow());
            entity.changeNum(stadiumDTO.getNum());
            entity.changeContent(stadiumDTO.getContent());

            stadiumRepository.save(entity);
            imageRepository.deleteBySno(stadiumDTO.getSno());

            // 이미지
            Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
            List<StadiumImage> stadiumImageList = (List<StadiumImage>) entityMap.get("imgList");
            stadiumImageList.forEach(stadiumImage -> {
                imageRepository.save(stadiumImage);
            });
        }
    }
}