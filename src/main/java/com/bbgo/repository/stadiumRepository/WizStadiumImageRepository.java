package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.WizStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface WizStadiumImageRepository extends JpaRepository<WizStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from WizStadiumImage where wizStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
