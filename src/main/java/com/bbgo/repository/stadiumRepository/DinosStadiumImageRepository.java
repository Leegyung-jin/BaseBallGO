package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.DinosStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface DinosStadiumImageRepository extends JpaRepository<DinosStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from DinosStadiumImage where dinosStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
