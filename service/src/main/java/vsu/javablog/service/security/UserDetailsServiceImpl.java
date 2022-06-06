package vsu.javablog.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return fromEntity(user);
    }

    private UserDetails fromEntity(UserEntity user) {
        SecurityUser securityUser = new SecurityUser(
            user.getEmail(),
            user.getPassword(),
            user.getRole());
        return securityUser;
    }
}
