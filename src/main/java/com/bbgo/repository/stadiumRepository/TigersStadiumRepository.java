package com.bbgo.repository.stadiumRepository;

import com.bbgo.entity.stadium.TigersStadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TigersStadiumRepository extends JpaRepository<TigersStadium, Long>, QuerydslPredicateExecutor<TigersStadium> {
    @Query("SELECT s, si " +
            "FROM TigersStadium s " +
            "LEFT OUTER JOIN TigersStadiumImage si ON ( si.tigersStadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
