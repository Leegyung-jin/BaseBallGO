package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.DinosStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DinosStadiumRepository extends JpaRepository<DinosStadium, Long>, QuerydslPredicateExecutor<DinosStadium> {
    @Query("SELECT s, si " +
            "FROM DinosStadium s " +
            "LEFT OUTER JOIN DinosStadiumImage si ON ( si.dinosStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
