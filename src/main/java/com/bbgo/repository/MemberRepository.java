package com.bbgo.repository;

import com.bbgo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
    @Query("SELECT COUNT(m.username) FROM Member m WHERE m.username =:username")
    int checkEmail(@Param("username") String username);

    Optional<Member> findByUsername(@Param("username") String username);
}
