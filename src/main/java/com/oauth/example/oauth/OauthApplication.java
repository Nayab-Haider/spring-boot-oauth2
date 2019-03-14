package com.oauth.example.oauth;

import com.oauth.example.oauth.entity.OAuthUser;
import com.oauth.example.oauth.repository.OAuthUserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OauthApplication implements CommandLineRunner {

    @Autowired
    private OAuthUserRepository oAuthUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static Logger logger = LogManager.getLogger(OauthApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OauthApplication.class, args);

        logger.info("|------------------------------------------|");
        logger.info("|                                          |");
        logger.info("|     Oauth2 Application SERVER START      |");
        logger.info("|                                          |");
        logger.info("|------------------------------------------|");
    }

    @Override
    public void run(String... args) throws Exception {
        OAuthUser oAuthUser = new OAuthUser();
        oAuthUser.setUserName("nayab");
        oAuthUser.setUserPasssword(passwordEncoder.encode("nayab"));
        oAuthUser.setUserRole("test");
        oAuthUserRepository.save(oAuthUser);
    }
}

