package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.TwinsStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TwinsStadiumImageRepository extends JpaRepository<TwinsStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from TwinsStadiumImage where twinsStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
