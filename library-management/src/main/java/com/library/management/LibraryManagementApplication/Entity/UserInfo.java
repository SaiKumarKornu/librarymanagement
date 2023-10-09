package com.library.management.LibraryManagementApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.LibraryManagementApplication.Dto.UserInfoDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id", nullable = false)
    private int id;

    @Column(name = "USer_name", nullable = false)
    private String name;
    @Column(name = "E_mail", nullable = false)
    private String email;
    @Column(name = "Phone_number", nullable = false)
    private String number;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "Role", nullable = false)
    private String roles;

    public UserInfo(UserInfoDto userInfoDto) {
        //  this.id = id;
        this.name = userInfoDto.getName();
        this.email = userInfoDto.getEmail();
        this.number = userInfoDto.getNumber();
        this.password = userInfoDto.getPassword();
        this.roles = userInfoDto.getRoles();
        // this.library_management = library_management;
    }

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    private List<LibraryManager> library_management;


//    public UserInfo(int id, String name, String email, String number, String password, String roles) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.roles = roles;
//        this.password = password;
//        this.name = number;
//    }

}

