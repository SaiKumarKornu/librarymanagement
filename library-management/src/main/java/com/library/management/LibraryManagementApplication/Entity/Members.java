//package com.library.management.LibraryManagementApplication.Entity;
//
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.library.management.LibraryManagementApplication.Dto.MemberDto;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Entity
//@Table(name="members")
//@Data
//@AllArgsConstructor
////@NoArgsConstructor
//public class Members {
//    @Id
//    @Column (name = "Member_id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int memberid;
//    @Column(name="name")
//    private String fullname;
//    @Column(name="e_mail")
//    private String email;
//    @Column(name="phone_number")
//    private String phonenumber;
//
//
//    public Members(MemberDto memberDto) {
//        this.memberid = memberDto.getMemberid();
//        this.fullname = memberDto.getFullname();
//        this.email = memberDto.getEmail();
//        this.phonenumber = memberDto.getPhonenumber();
//
//    }
//
//    public Members() {
//    }
//
//    @OneToMany(mappedBy = "members")
//    @JsonIgnore
//    private List<LibraryManager> library_management;
//
//
//}
