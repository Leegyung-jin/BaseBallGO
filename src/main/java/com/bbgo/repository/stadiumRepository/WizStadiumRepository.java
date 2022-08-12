package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.TwinsStadium;
import com.bbgo.entity.stadium.WizStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WizStadiumRepository extends JpaRepository<WizStadium, Long>, QuerydslPredicateExecutor<WizStadium> {
    @Query("SELECT s, si " +
            "FROM WizStadium s " +
            "LEFT OUTER JOIN WizStadiumImage si ON ( si.wizStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
