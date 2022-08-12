package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.StadiumImage;
import com.bbgo.entity.stadium.QTigersStadium;
import com.bbgo.entity.stadium.TigersStadium;
import com.bbgo.entity.stadium.TigersStadiumImage;
import com.bbgo.repository.StadiumImageRepository;
import com.bbgo.repository.stadiumRepository.TigersStadiumRepository;
import com.bbgo.repository.stadiumRepository.WizStadiumRepository;
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
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class TigersServiceImpl implements TigersService {

    private final TigersStadiumRepository repository;
    private final StadiumImageRepository imageRepository;

    // List
    @Override
    public PageResultDTO<StadiumDTO, TigersStadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());

        // 검색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<TigersStadium> result = repository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<TigersStadium, StadiumDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QTigersStadium qTigersStadium = QTigersStadium.tigersStadium;


        // sno > 0조건 생성
        BooleanExpression expression = qTigersStadium.sno.gt(0L);
        booleanBuilder.and(expression);


        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("1")) {
            conditionBuilder.or(qTigersStadium.base.contains("1")).and(qTigersStadium.section.contains(keyword));
        }
        if (type.contains("2")) {
            conditionBuilder.or(qTigersStadium.base.contains("중앙")).and(qTigersStadium.section.contains(keyword));
        }
        if (type.contains("3")) {
            conditionBuilder.or(qTigersStadium.base.contains("3")).and(qTigersStadium.section.contains(keyword));
        }

        // 모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }


    // Register
    @Transactional
    @Override
    public Long register(StadiumDTO stadiumDTO) {
        Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
        TigersStadium stadium = (TigersStadium) entityMap.get("stadium");
        List<StadiumImage> stadiumImageList = (List<StadiumImage>) entityMap.get("imgList");

        repository.save(stadium);

        stadiumImageList.forEach(stadiumImage -> {
            imageRepository.save(stadiumImage);
        });

        return stadium.getSno();
    }

    @Override
    public StadiumDTO getStadium(Long sno) {
        List<Object[]> result = repository.getStadiumWithAll(sno);
        TigersStadium stadium = (TigersStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<TigersStadiumImage> stadiumImageList = new ArrayList<>();    // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            TigersStadiumImage stadiumImage = (TigersStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO entitiesToDTO(TigersStadium stadium, List<TigersStadiumImage> stadiumImages) {
        System.out.println("================== entitiesToDTO= " + stadium);
        return TigersService.super.entitiesToDTO(stadium, stadiumImages);
    }
}