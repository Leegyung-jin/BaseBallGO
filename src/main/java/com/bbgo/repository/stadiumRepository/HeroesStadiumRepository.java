package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.Stadium;
import com.bbgo.entity.stadium.HeroesStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HeroesStadiumRepository extends JpaRepository<HeroesStadium, Long>, QuerydslPredicateExecutor<HeroesStadium> {
    @Query("SELECT s, si " +
            "FROM HeroesStadium s " +
            "LEFT OUTER JOIN HeroesStadiumImage si ON ( si.heroesStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
