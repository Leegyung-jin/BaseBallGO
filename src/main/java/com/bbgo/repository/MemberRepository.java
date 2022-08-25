package com.bbgo.repository;

import com.bbgo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
    @Query("SELECT COUNT(m.username) FROM Member m WHERE m.username =:email")
    int checkEmail(@Param("email") String email);
}
