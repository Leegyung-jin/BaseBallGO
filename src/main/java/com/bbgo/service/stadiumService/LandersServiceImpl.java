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
        Function<Stadium, StadiumDTO> fn = (entity -> entityToDto(entity));

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
}