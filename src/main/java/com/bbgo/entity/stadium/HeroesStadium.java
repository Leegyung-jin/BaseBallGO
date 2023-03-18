package com.bbgo.entity.stadium;

import com.bbgo.entity.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"team", "member"})
public class HeroesStadium extends SBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String base;
    private String section;
    private String sRow;
    private Integer num;
    private String content;

    private String username;
    private String name;
    private Long mno;

    public void changeRow(String row){
        this.sRow = row;
    }
    public void changeNum(Integer num){
        this.num = num;
    }
    public void changeContent(String content){
        this.content = content;
    }
}
