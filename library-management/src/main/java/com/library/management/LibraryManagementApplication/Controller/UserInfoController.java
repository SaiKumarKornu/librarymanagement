package com.library.management.LibraryManagementApplication.Controller;

import com.library.management.LibraryManagementApplication.Dto.UserInfoDto;
import com.library.management.LibraryManagementApplication.Dto.UserInfoDtoAuthRequest;
import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import com.library.management.LibraryManagementApplication.jwtService.JwtService;
import com.library.management.LibraryManagementApplication.serviceimplementation.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userinfo")

public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    JwtService jwtService;

    @Autowired
  private   AuthenticationManager authenticationManager;


    @PostMapping("/adduser")
    public String create(@RequestBody UserInfoDto userInfoDto) {

        UserInfoDto userInfoDtos = userInfoService.create(userInfoDto);
        return "user created succesfully";

    }

    @PostMapping("/auth")
    public  String token(@RequestBody UserInfoDtoAuthRequest userInfoDtoAuthRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userInfoDtoAuthRequest.getUsername(), userInfoDtoAuthRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(userInfoDtoAuthRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user!");
       }
    }
    @GetMapping("/get")
    //@PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<UserInfo> getall() {
        return ResponseEntity.status(HttpStatus.OK).body(userInfoService.getall());
    }
}