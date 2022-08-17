package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.LandersStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LandersStadiumRepository extends JpaRepository<LandersStadium, Long>, QuerydslPredicateExecutor<LandersStadium> {


    @Query("SELECT s, si " +
            "FROM LandersStadium s " +
            "LEFT OUTER JOIN LandersStadiumImage si ON ( si.landersStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
