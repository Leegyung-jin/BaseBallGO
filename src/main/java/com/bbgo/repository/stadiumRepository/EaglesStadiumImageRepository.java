package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.EaglesStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EaglesStadiumImageRepository extends JpaRepository<EaglesStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from EaglesStadiumImage where eaglesStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
