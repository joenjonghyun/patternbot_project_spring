package kr.co.patternbot.auth.domains;

import kr.co.patternbot.users.domains.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Auth implements UserDetails {
    //상수로 처리 <-> User는 변수로 처리
    private final long userid;
    private final String username;
    private final String name;
    @JsonIgnore
    private final String password;
    private final String email;
    private final String mobile;

    public static Auth build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toList());
        return new Auth(user.getUserid(), user.getUsername(),user.getMobile(), user.getPassword(), user.getName(), user.getEmail(), authorities);
    }
    private final Collection<? extends GrantedAuthority> authorities;
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