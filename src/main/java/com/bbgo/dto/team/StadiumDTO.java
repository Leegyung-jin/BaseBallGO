package com.bbgo.dto.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StadiumDTO {

    private Long sno;           // Stadium number
    private String base;       // 1루/3루
    private String section;     // Stadium 구역
    private String sRow;         // Stadium 좌석(열)
    private Integer num;        // Stadium 좌석(번호)
    private String content;     // 내용

    private String username;    // Member email
    private String name;        // Member 닉네임
    private Long mno;           // Member Mno

    @Builder.Default
    private List<StadiumImageDTO> imageDTOList = new ArrayList<>();

    private LocalDateTime regDate;  // 등록일
    private LocalDateTime modDate;  // 수정일
}
