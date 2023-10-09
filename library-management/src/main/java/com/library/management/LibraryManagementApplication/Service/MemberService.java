//package com.library.management.LibraryManagementApplication.Service;
//
//import com.library.management.LibraryManagementApplication.Dto.MemberDto;
//import com.library.management.LibraryManagementApplication.Entity.Members;
//import com.library.management.LibraryManagementApplication.Entity.UserInfo;
//import com.library.management.LibraryManagementApplication.Exceptions.ObjectNotValid;
//import com.library.management.LibraryManagementApplication.Repository.MemberRepository;
//import com.library.management.LibraryManagementApplication.Repository.UserInfoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MemberService {
//
//@Autowired
//    MemberRepository memberRepository;
//
//
//
//
//    public MemberDto create(MemberDto memberDto) {
//        if(memberDto==null){
//            throw new ObjectNotValid("mention the details");
//        }else {
//            Members members = new Members();
//            members.setFullname(memberDto.getFullname());
//            members.setEmail(memberDto.getEmail());
//            members.setPhonenumber(memberDto.getPhonenumber());
//            memberRepository.save(members);
//            return new MemberDto(members);
//        }
//    }
//
//
//}
