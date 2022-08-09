package com.bbgo.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tno;

    private String sName;   // Stadium Name
    private String tName;   // Team Name
}
