package com.example.medClinic.user.service;

import com.example.medClinic.user.entity.ClientEntity;
import com.example.medClinic.user.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ClientAuthService implements UserDetailsService {
    private final ClientRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ClientEntity> userEntityOptional = userRepository.findByEmail(email);
        if (userEntityOptional.isEmpty()) throw new UsernameNotFoundException("User with this email not found");

        ClientEntity user = userEntityOptional.get();
        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("user"));

        return new User(user.getEmail(), user.getPassword(),authorities);
    }
}
