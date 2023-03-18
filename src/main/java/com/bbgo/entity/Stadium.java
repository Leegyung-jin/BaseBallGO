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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String base;
    private String section;
    private String rows;
    private Integer num;
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Member member;

    public void changeRow(String row){
        this.rows = row;
    }
    public void changeNum(Integer num){
        this.num = num;
    }
    public void changeContent(String content){
        this.content = content;
    }
}
