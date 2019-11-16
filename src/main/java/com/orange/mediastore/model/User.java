package com.orange.mediastore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Document(collection = "users")
public class User implements UserDetails {

    @Id
    private String id;

    @NotEmpty
    @Indexed(unique = true)
    private String username;

    @NotEmpty
    private String password;

    private Set<String> favouritesIds;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    public Set<String> getFavouritesIds() {
        return favouritesIds;
    }

    public void setFavouritesIds(Set<String> favouritesIds) {
        this.favouritesIds = favouritesIds;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
