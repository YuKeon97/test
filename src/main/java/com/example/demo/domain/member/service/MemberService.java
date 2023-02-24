package com.example.demo.domain.member.service;

import com.example.demo.domain.member.dto.MemberResposeDto;
import com.example.demo.domain.member.dto.UpdateMemberDto;
import com.example.demo.domain.member.entity.Member;
import com.example.demo.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void saveMember(String email, String name) {
        Member member = new Member();
        member.setEmail(email);
        member.setName(name);
        memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        Member result = memberRepository.findById(id).orElseThrow(null);
        System.out.println("result.email = " + result.getEmail());
        System.out.println("result.name = " + result.getName());
        memberRepository.delete(result);
    }

    public MemberResposeDto getMember(Long id) {
        Member result = memberRepository.findById(id).orElseThrow(null);
        MemberResposeDto dto = new MemberResposeDto();
        dto.setEmail(result.getEmail());
        dto.setName(result.getName());
        return dto;
    }

    public Member updateMember(UpdateMemberDto dto) {
        Member result = memberRepository.findById(dto.getId()).orElseThrow(null);
        result.setEmail(dto.getEmail());
        result.setName(dto.getName());
        memberRepository.save(result);
        return result;
    }

    public List<Member> findname(String name) {
        return memberRepository.findByName(name);
    }
}
