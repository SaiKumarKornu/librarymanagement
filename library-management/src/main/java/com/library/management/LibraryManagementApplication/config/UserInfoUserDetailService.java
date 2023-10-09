package com.library.management.LibraryManagementApplication.config;

import com.library.management.LibraryManagementApplication.Dto.UserInfoDto;
import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import com.library.management.LibraryManagementApplication.Repository.UserInfoRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component

public class UserInfoUserDetailService implements UserDetailsService {

@Autowired
    UserInfoRepository userInfoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           Optional<UserInfo> userInfo= userInfoRepository.findByName(username);
           return userInfo.map(UserInfoUserDetails::new)
                   .orElseThrow(()->new UsernameNotFoundException("user not found"+username));
    }

}
