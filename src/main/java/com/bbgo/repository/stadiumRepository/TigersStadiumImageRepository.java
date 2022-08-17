package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.TigersStadiumImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TigersStadiumImageRepository extends JpaRepository<TigersStadiumImage, Long> {
    @Transactional
    @Modifying
    @Query("delete from TigersStadiumImage where tigersStadium.sno =:sno")
    void deleteBySno(@Param("sno") Long sno);
}
