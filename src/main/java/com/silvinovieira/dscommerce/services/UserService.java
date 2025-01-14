package com.silvinovieira.dscommerce.services;

import com.silvinovieira.dscommerce.dto.UserDTO;
import com.silvinovieira.dscommerce.entities.Role;
import com.silvinovieira.dscommerce.entities.User;
import com.silvinovieira.dscommerce.projections.UserDetailsProjection;
import com.silvinovieira.dscommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetailsProjection> list = userRepository.searchUserAndRolesByEmail(username);

        if (list.size() == 0){
            throw new UsernameNotFoundException("user not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(list.get(0).getPassword());

        for (UserDetailsProjection projection : list) {
        user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return user;
    }

    protected User authenticated(){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return userRepository.findByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user not found");
        }
    }

    @Transactional(readOnly = true)
    public UserDTO getMe(){
        User user = authenticated();
        return new UserDTO(user);
    }
}
