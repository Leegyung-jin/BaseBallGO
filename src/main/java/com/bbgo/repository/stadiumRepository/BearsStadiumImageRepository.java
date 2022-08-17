package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.JamsilStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface BearsStadiumImageRepository extends JpaRepository<JamsilStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from JamsilStadiumImage where jamsilStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
