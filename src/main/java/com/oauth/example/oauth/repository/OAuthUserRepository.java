package com.oauth.example.oauth.repository;

import com.oauth.example.oauth.entity.OAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OAuthUserRepository extends JpaRepository<OAuthUser,Long>{

   OAuthUser findByUserName(String userName);
}
