package com.bbgo.service.stadiumService;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.Stadium;
import com.bbgo.entity.StadiumImage;
import com.bbgo.repository.StadiumImageRepository;
import com.bbgo.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class LandersServiceImpl implements LandersService{

    private final StadiumRepository stadiumRepository;
    private final StadiumImageRepository imageRepository;

    // List
    @Override
    public PageResultDTO<StadiumDTO, Stadium> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("sno").descending());
        Page<Stadium> result = stadiumRepository.findAll(pageable);
        Function<Stadium, StadiumDTO> fn = (entity -> entityToDTO(entity));

        return new PageResultDTO<>(result, fn);
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
}