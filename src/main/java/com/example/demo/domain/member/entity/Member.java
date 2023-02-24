package com.example.demo.domain.member.entity;

import com.example.demo.domain.comment.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;


    @OneToMany(mappedBy = "member")
    private List<Comment> comments = new ArrayList<>();


}
