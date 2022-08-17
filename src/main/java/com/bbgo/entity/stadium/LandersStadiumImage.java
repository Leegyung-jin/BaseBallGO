package com.bbgo.entity.stadium;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "LaandersStadium")
public class LandersStadiumImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ino;

    private String uuid;
    private String imgName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    private LandersStadium landersStadium;
}
