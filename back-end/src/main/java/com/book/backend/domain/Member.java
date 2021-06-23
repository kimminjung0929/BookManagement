package com.book.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Member {

    @Id
    @Column(name = "member_id", unique = true)
    private String id;

    private String name;

    private String phone;


}
