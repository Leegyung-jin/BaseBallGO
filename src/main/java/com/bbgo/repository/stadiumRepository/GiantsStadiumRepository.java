package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.GiantsStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiantsStadiumRepository extends JpaRepository<GiantsStadium, Long>, QuerydslPredicateExecutor<GiantsStadium> {
    @Query("SELECT s, si " +
            "FROM GiantsStadium s " +
            "LEFT OUTER JOIN GiantsStadiumImage si ON ( si.giantsStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
