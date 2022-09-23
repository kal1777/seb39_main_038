package com.main_39.Spring.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localId;

    @Column(length = 50,nullable = false)
    private String profileNickname;

    @Column(length = 255)
    private String profileImage;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String accountEmail;

    //암호화로 인해 최소 60자
    @Column(length = 255, nullable = false)
    private String localPassword;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @Setter
    @Column(nullable = true, updatable = true, unique = true)
    private String refreshToken;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Role role = Role.SELLER;

    //외래키 도입 전

    public enum Role{
        SELLER("ROLE_SELLER"),
        ADMIN("ROLE_ADMIN");

        @Getter
        private String status;

        Role(String status){
            this.status = status;
        }
    }

}