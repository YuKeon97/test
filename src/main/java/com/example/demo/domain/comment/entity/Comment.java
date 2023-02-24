package com.example.demo.domain.comment.entity;

import com.example.demo.domain.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private long id;

    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

}
