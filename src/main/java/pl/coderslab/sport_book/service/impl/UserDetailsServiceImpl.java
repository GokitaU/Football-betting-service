package pl.coderslab.sport_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.sport_book.model.CurrentUser;
import pl.coderslab.sport_book.model.Role;
import pl.coderslab.sport_book.model.User;
import pl.coderslab.sport_book.service.UserDetailsService;
import pl.coderslab.sport_book.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user=userService.getByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for (Role role:user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new CurrentUser(user.getUsername(), user.getPassword(), grantedAuthorities, user);
    }

    @Override
    public boolean findEmailAndUsername(String username, String email){

        try {
            if (userService.getByUsername(username)==null && userService.findByMail(email)==null){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
