package com.prajjwal.SpringBootAPI.Services;

import com.prajjwal.SpringBootAPI.Model.UserEntity;
import com.prajjwal.SpringBootAPI.Model.UserPrincipal;
import com.prajjwal.SpringBootAPI.Repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    private UserRepo repo;
    public MyUserDetails(UserRepo repo){
        this.repo=repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repo.findByUsername(username);

        if(user==null){
            System.out.println("User Not Found-404");
            throw new UsernameNotFoundException("User Not Found-404");
        }
        return new UserPrincipal(user);
    }
}
