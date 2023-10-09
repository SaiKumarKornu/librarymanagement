package com.library.management.LibraryManagementApplication.serviceimplementation;


import com.library.management.LibraryManagementApplication.Dto.UserInfoDto;
import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface UserInfoService {


    UserInfoDto create(UserInfoDto userInfoDto);

    UserInfo getall();

    //  List<UserInfoDto> getall();
}
