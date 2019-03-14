package com.oauth.example.oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("{authorization.server.config.client_id}")
    static String CLIEN_ID;

    @Value("{authorization.server.config.client_secret}")
    static String CLIENT_SECRET;

    @Value("{authorization.server.config.grant_type}")
    static String GRANT_TYPE;

    @Value("{authorization.server.config.authorization_code}")
    static String AUTHORIZATION_CODE;

    @Value("{authorization.server.config.refresh_token}")
    static String REFRESH_TOKEN;

    @Value("{authorization.server.config.implicit}")
    static String IMPLICIT;

    @Value("{authorization.server.config.scope_read}")
    static String SCOPE_READ;

    @Value("{authorization.server.config.scope_write}")
    static String SCOPE_WRITE;

    @Value("{authorization.server.config.trust}")
    static String TRUST;

    @Value("{authorization.server.config.access_token_validity_second}")
    static int ACCESS_TOKEN_VALIDITY_SECONDS;

    @Value("{authorization.server.config.refresh_token_validity_seconds}")
    static int FREFRESH_TOKEN_VALIDITY_SECONDS;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(CLIEN_ID)
                .secret(CLIENT_SECRET)
                .authorizedGrantTypes(GRANT_TYPE, AUTHORIZATION_CODE, REFRESH_TOKEN)
                .scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
                .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authManager);
    }
}
