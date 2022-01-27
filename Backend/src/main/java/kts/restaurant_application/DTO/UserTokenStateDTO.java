package kts.restaurant_application.DTO;

import kts.restaurant_application.model.Authority;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

// DTO koji enkapsulira generisani JWT i njegovo trajanje koji se vracaju klijentu
public class UserTokenStateDTO {

    private String accessToken;
    private int expiresIn;
    private Long userId;
    Collection<? extends GrantedAuthority> authorities;

    public UserTokenStateDTO() {
        this.accessToken = null;
        this.expiresIn = 0;
    }

    public UserTokenStateDTO(String accessToken, int expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }

    public UserTokenStateDTO(String jwt, int expiresIn, Long id, Collection<? extends GrantedAuthority> authorities) {
        this.accessToken = jwt;
        this.expiresIn = expiresIn;
        this.userId = id;
        this.authorities = authorities;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


}
