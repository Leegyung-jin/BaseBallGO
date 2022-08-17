package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.LandersStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LandersStadiumImageRepository extends JpaRepository<LandersStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from LandersStadiumImage where landersStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
