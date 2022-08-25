package com.bbgo.entity.stadium;

import com.bbgo.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"member"})
public class LandersStadium extends SBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String base;
    private String section;
    private String row;
    private Integer num;
    private String content;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Member member;
    private String username;
    private String name;
    private Long mno;

    public void changeRow(String row){
        this.row = row;
    }
    public void changeNum(Integer num){
        this.num = num;
    }
    public void changeContent(String content){
        this.content = content;
    }
}
