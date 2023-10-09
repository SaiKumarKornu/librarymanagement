package com.library.management.LibraryManagementApplication.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDtoAuthRequest {

    private String username;
    private  String password;

}
