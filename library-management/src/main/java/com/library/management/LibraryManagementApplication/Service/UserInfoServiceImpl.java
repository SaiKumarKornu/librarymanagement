package com.library.management.LibraryManagementApplication.Service;


import com.library.management.LibraryManagementApplication.Dto.UserInfoDto;
import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import com.library.management.LibraryManagementApplication.Exceptions.ObjectNotValid;
import com.library.management.LibraryManagementApplication.Repository.UserInfoRepository;
import com.library.management.LibraryManagementApplication.serviceimplementation.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
@Autowired
    PasswordEncoder passwordEncoder;


   public UserInfoDto create(UserInfoDto userInfoDto){
       if(userInfoDto==null){
           throw new ObjectNotValid("mention the details");
       }else {
           UserInfo userInfo = new UserInfo();
           userInfo.setName(userInfoDto.getName());
          userInfo.setEmail(userInfoDto.getEmail());
          userInfo.setNumber(userInfoDto.getNumber());
          userInfo.setRoles(userInfoDto.getRoles());
          userInfo.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
           userInfoRepository.save(userInfo);
           return new UserInfoDto(userInfo);
       }

   }

    @Override
    public UserInfo getall() {
       String name=SecurityContextHolder.getContext().getAuthentication().getName();
        UserInfo userInfo = userInfoRepository.findByName(name) .orElseThrow(()->new UsernameNotFoundException("user not found"));
        return userInfo;
    }


}
