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
public class TwinsStadium extends SBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sno;

    private String base;
    private String section;
    private String row;
    private Integer num;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;
}
