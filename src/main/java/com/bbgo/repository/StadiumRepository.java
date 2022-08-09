package com.bbgo.repository;

import com.bbgo.entity.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StadiumRepository extends JpaRepository<Stadium, Long>, QuerydslPredicateExecutor<Stadium> {

//    @Query("select s.sno, s.base, s.section, s.row, s.num from Stadium s")
//    Page<Object[]> getListPage(Pageable pageable);

//    @Query(countQuery = "SELECT count(s) FROM Stadium s")
//    Page<Object[]> getStadiumCnt(Pageable pageable);
}
