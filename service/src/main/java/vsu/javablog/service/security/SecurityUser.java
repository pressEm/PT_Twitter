package vsu.javablog.service.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import vsu.javablog.db.entities.RoleEntity;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
public class SecurityUser implements UserDetails {

    private String username;
    private String password;
    private Set<RoleEntity> role = new HashSet<>();

    public SecurityUser(String username, String password, RoleEntity role) {
        this.username = username;
        this.password = password;
//        role.getAuthority();
//        Collections.singleton(Role.valueOf(role.getRoleName()));
//        String r = Role.valueOf(role.getAuthority());
        this.role.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
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
