package com.bbgo.repository;

import com.bbgo.dto.common.PageRequestDTO;
import com.bbgo.dto.common.PageResultDTO;
import com.bbgo.dto.team.StadiumDTO;
import com.bbgo.entity.Member;
import com.bbgo.entity.Stadium;
import com.bbgo.entity.StadiumImage;
import com.bbgo.entity.Team;
import com.bbgo.service.stadiumService.LandersService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
public class StadiumRepositoryTests {

    @Autowired
    private LandersService landersService;
    @Autowired
    private StadiumRepository stadiumRepository;
    @Autowired
    private StadiumImageRepository imageRepository;

    @Commit
    @Transactional
    @Test
    public void insertStadium() {
        IntStream.rangeClosed(1,1).forEach(i -> {

            // 팀 번호
            Integer t = 1;
            Long l = new Long(t);
            Team team = Team.builder().tno(l).build();

            // Member 번호
            Long mno = ((long)(Math.random()*10)+1);
            Member member = Member.builder().mno(mno).build();

            Stadium stadium = Stadium.builder()
//                    .team(team)
                    .base(1)
                    .section("노브랜드 테이블석")
                    .row("I")
                    .num(10)
                    .content("가성비가 좋아요.")
                    .member(member)
                    .build();
            stadiumRepository.save(stadium);

            int count = (int)(Math.random() * 5) + 1;

            for (int j=0; j<count; j++){
                StadiumImage stadiumImage = StadiumImage.builder()
                        .uuid(UUID.randomUUID().toString())
                        .stadium(stadium)
                        .imgName("test"+j+".jpg")
                        .build();
                imageRepository.save(stadiumImage);
            }
        });
    }

    // Paging
    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(1).size(10).build();
        PageResultDTO<StadiumDTO, Stadium> resultDto = landersService.getList(pageRequestDTO);

        System.out.println("PREV: " + resultDto.isPrev());
        System.out.println("NEXT: " + resultDto.isNext());
        System.out.println("TOTAL: " + resultDto.getTotalPage());
        for (StadiumDTO stadiumDTO : resultDto.getDtoList()) {
            System.out.println(stadiumDTO);
        }
    }

    @Test
    public void testGetStadiumCnt() {
        
    }

}
