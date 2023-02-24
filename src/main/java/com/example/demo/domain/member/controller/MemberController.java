package com.example.demo.domain.member.controller;

import com.example.demo.domain.member.dto.MemberResposeDto;
import com.example.demo.domain.member.dto.UpdateMemberDto;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 객체 반환 시 JSON 변환을 해준다.
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/v1/users")
public class MemberController {
    /**
     * 1. 회원가입 api/v1/users/new
     * 2. 삭제 api/v1/users/{1} <-> api/v1/users?userId=1&email=dbrjs
     * 3. 회원 조회 api/v1/users/{1}
     * 4. 업데이트 api/v1/users/{1}
     * 5. 이름으로 조회 api/v1/users?name={name}
     */

    private final MemberService memberService;

    @PostMapping("/new")
    public void create(@RequestParam String email,
                     @RequestParam String name) {
        memberService.saveMember(email, name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping("/{id}")
    public MemberResposeDto read(@PathVariable Long id) {
        return memberService.getMember(id);
    }

    @PutMapping ("/{id}")
    public Member update(@PathVariable Long id,
                         @RequestBody UpdateMemberDto dto) {
        return memberService.updateMember(id, dto);
    }

    @GetMapping("/")
    public List<Member> findByName(@RequestParam String  name) {
        return memberService.findname(name);
    }
}
