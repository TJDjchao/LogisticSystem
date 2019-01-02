package com.neo.logisiticsystem.Service;

import com.neo.logisiticsystem.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail implements UserDetailsService {
    @Autowired
    private UserDao userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username);
    }

}
