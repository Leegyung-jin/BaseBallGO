package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.GiantsStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface GiantsStadiumImageRepository extends JpaRepository<GiantsStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from GiantsStadiumImage where giantsStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
