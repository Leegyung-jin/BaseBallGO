package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.LionsStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LionsStadiumRepository extends JpaRepository<LionsStadium, Long>, QuerydslPredicateExecutor<LionsStadium> {
    @Query("SELECT s, si " +
            "FROM LionsStadium s " +
            "LEFT OUTER JOIN LionsStadiumImage si ON ( si.lionsStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
