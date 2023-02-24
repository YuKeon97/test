package com.example.demo.domain.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateMemberDto {
    private Long id;
    private String email;
    private String name;
}
