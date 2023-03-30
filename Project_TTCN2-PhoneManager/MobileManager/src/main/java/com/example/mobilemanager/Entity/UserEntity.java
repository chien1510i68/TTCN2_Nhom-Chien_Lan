package com.example.mobilemanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userID;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "addr")
    private String addr;

    @Column(name = "user_name")
    private String userName;


}
