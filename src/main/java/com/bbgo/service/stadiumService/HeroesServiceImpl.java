package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.stadium.HeroesStadium;
import com.bbgo.entity.stadium.HeroesStadiumImage;
import com.bbgo.entity.stadium.QHeroesStadium;
import com.bbgo.repository.stadiumRepository.HeroesStadiumImageRepository;
import com.bbgo.repository.stadiumRepository.HeroesStadiumRepository;
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
public class HeroesServiceImpl implements HeroesService{

    private final HeroesStadiumRepository repository;
    private final HeroesStadiumImageRepository imageRepository;

    // List
    @Override
    public PageResultDTO<StadiumDTO, HeroesStadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());

        // 검색
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<HeroesStadium> result = repository.findAll(booleanBuilder, pageable);  // Querydsl 사용

        Function<HeroesStadium, StadiumDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QHeroesStadium qHeroesStadium = QHeroesStadium.heroesStadium;

        // sno > 0조건 생성
        BooleanExpression expression = qHeroesStadium.sno.gt(0L);
        booleanBuilder.and(expression);


        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("1")) {
            conditionBuilder.or(qHeroesStadium.base.contains("1")).and(qHeroesStadium.section.contains(keyword));
        }
        if (type.contains("2")) {
            conditionBuilder.or(qHeroesStadium.base.contains("2")).and(qHeroesStadium.section.contains(keyword));
        }
        if (type.contains("3")) {
            conditionBuilder.or(qHeroesStadium.base.contains("3")).and(qHeroesStadium.section.contains(keyword));
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
        HeroesStadium stadium = (HeroesStadium) entityMap.get("stadium");
        List<HeroesStadiumImage> stadiumImageList = (List<HeroesStadiumImage>) entityMap.get("imgList");

        repository.save(stadium);


        if (stadiumImageList != null && stadiumImageList.size() > 0) {
            stadiumImageList.forEach(stadiumImage -> {
                imageRepository.save(stadiumImage);
            });
        }

        return stadium.getSno();
    }

    @Override
    public StadiumDTO getStadium(Long sno) {
        List<Object[]> result = repository.getStadiumWithAll(sno);
        HeroesStadium stadium = (HeroesStadium) result.get(0)[0];               // Movie 엔티티는 가장 앞에 존재한다. - 모든 Row가 동일한 값
        List<HeroesStadiumImage> stadiumImageList = new ArrayList<>();    // 영화의 이미지 개수만큼 MovieImage가 필요하다.

        result.forEach(arr -> {
            HeroesStadiumImage stadiumImage = (HeroesStadiumImage) arr[1];
            stadiumImageList.add(stadiumImage);
        });

        return entitiesToDTO(stadium, stadiumImageList);
    }

    @Override
    public StadiumDTO entitiesToDTO(HeroesStadium stadium, List<HeroesStadiumImage> stadiumImages) {
        return HeroesService.super.entitiesToDTO(stadium, stadiumImages);
    }

    @Override
    public void modify(StadiumDTO stadiumDTO) {
        Optional<HeroesStadium> result = repository.findById(stadiumDTO.getSno());
        if(result.isPresent()){
            HeroesStadium entity = result.get();

            String upperRow = stadiumDTO.getRow().toUpperCase();
            entity.changeRow(upperRow);
            entity.changeNum(stadiumDTO.getNum());
            entity.changeContent(stadiumDTO.getContent());

            repository.save(entity);
            imageRepository.deleteBySno(stadiumDTO.getSno());

            // 이미지
            Map<String, Object> entityMap = dtoToEntity(stadiumDTO);
            List<HeroesStadiumImage> stadiumImageList = (List<HeroesStadiumImage>) entityMap.get("imgList");
            stadiumImageList.forEach(stadiumImage -> {
                imageRepository.save(stadiumImage);
            });
        }
    }
}