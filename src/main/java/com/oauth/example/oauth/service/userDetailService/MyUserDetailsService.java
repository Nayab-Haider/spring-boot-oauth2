package com.oauth.example.oauth.service.userDetailService;

import com.oauth.example.oauth.entity.OAuthUser;
import com.oauth.example.oauth.repository.OAuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private OAuthUserRepository oAuthUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public MyUserDetailsService(OAuthUserRepository oAuthUserRepository) {
        this.oAuthUserRepository = oAuthUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        final Optional<OAuthUser> oAuthUser = oAuthUserRepository.findById(Long.valueOf(userName));
        if (oAuthUser.isPresent()) {
            OAuthUser user = oAuthUser.get();
            return new User(user.getUserName(),
                    passwordEncoder.encode(user.getUserPasssword()),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getUserRole())));
        }
        return null;
    }
}
