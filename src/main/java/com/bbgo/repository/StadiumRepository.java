package com.bbgo.repository;

import com.bbgo.entity.Stadium;
import com.querydsl.core.BooleanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StadiumRepository extends JpaRepository<Stadium, Long>, QuerydslPredicateExecutor<Stadium> {
//public interface StadiumRepository extends JpaRepository<Stadium, Long> {

//    @Query("SELECT s, si " +
//            "FROM Stadium s " +
//            "LEFT OUTER JOIN StadiumImage si ON si.stadium = s " +
//            "WHERE si.sno = :sno GROUP BY si")
//    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);

    @Query("SELECT s, si " +
            "FROM Stadium s " +
            "LEFT OUTER JOIN StadiumImage si ON ( si.stadium = s) " +
            "WHERE s.sno =:sno GROUP BY si")
    List<Object[]> getStadiumWithAll(@Param("sno") Long sno);   // 게시글 조회
}
