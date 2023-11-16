package com.gmail.merikbest.ecommerce.security.oauth2;

import com.gmail.merikbest.ecommerce.enums.AuthProvider;
import lombok.SneakyThrows;

import javax.security.sasl.AuthenticationException;
import java.util.Map;

public class OAuth2UserFactory {

    @SneakyThrows
    public static OAuth2UserInfo getOAuthUserInfo(String registrationId, Map<String , Object> attributes) {
        if (registrationId.equalsIgnoreCase(AuthProvider.GOOGLE.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.FACEBOOK.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        }else if (registrationId.equalsIgnoreCase(AuthProvider.GITHUB.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        }else {
            throw new AuthenticationException();
        }
    }
}
