package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.HeroesStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HeroesStadiumImageRepository extends JpaRepository<HeroesStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from HeroesStadiumImage where heroesStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
