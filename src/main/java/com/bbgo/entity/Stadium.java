package com.bbgo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"team", "member"})
public class Stadium extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sno;

//    private Integer base;
    private String base;
    private String section;
    private String row;
    private Integer num;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
