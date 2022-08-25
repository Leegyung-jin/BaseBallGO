package com.bbgo.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long mno;
    private String username;
    private String name;
    private String password;

    private LocalDateTime regDate;  // 등록일
    private LocalDateTime modDate;  // 수정일
}
