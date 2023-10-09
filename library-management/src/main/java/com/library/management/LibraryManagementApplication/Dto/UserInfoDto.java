package com.library.management.LibraryManagementApplication.Dto;

import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class UserInfoDto {
     private int id;
    private String name;
    private String email;
    private String number;
    private String password;
    private String roles;




    public UserInfoDto(UserInfo userInfo) {
        this.id = userInfo.getId();
        this.name = userInfo.getName();
        this.email = userInfo.getEmail();
        this.number = userInfo.getNumber();
        this.password = userInfo.getPassword();
        this.roles = userInfo.getRoles();
        // this.library_management = library_management;
    }

}
