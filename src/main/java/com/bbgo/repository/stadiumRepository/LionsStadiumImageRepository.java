package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.LionsStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LionsStadiumImageRepository extends JpaRepository<LionsStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from LionsStadiumImage where lionsStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
