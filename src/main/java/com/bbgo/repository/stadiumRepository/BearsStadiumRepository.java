package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.JamsilStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BearsStadiumRepository extends JpaRepository<JamsilStadium, Long>, QuerydslPredicateExecutor<JamsilStadium> {
    @Query("SELECT s, si " +
            "FROM JamsilStadium s " +
            "LEFT OUTER JOIN JamsilStadiumImage si ON ( si.jamsilStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
