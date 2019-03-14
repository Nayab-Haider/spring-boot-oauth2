package com.oauth.example.oauth.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "oauth_user")
@Data
public class OAuthUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private String userPasssword;

    private String userRole;
}
