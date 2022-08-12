package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.TwinsStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TwinsStadiumRepository extends JpaRepository<TwinsStadium, Long>, QuerydslPredicateExecutor<TwinsStadium> {
    @Query("SELECT s, si " +
            "FROM TwinsStadium s " +
            "LEFT OUTER JOIN TwinsStadiumImage si ON ( si.twinsStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
