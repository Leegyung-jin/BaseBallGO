package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.StadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LandersStadiumImageRepository extends JpaRepository<StadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from StadiumImage where stadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
