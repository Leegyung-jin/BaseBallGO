package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.EaglesStadium;
import com.bbgo.entity.stadium.WizStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EaglesStadiumRepository extends JpaRepository<EaglesStadium, Long>, QuerydslPredicateExecutor<EaglesStadium> {
    @Query("SELECT s, si " +
            "FROM EaglesStadium s " +
            "LEFT OUTER JOIN EaglesStadiumImage si ON ( si.eaglesStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
