package com.example.mobilemanager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "addr")
    private String addr;
}
