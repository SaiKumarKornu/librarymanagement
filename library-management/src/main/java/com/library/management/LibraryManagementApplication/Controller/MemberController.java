//package com.library.management.LibraryManagementApplication.Controller;
//
//import com.library.management.LibraryManagementApplication.Dto.LibraryManagerDto;
//import com.library.management.LibraryManagementApplication.Dto.MemberDto;
//import com.library.management.LibraryManagementApplication.Entity.Members;
//import com.library.management.LibraryManagementApplication.Entity.UserInfo;
//import com.library.management.LibraryManagementApplication.Repository.MemberRepository;
//import com.library.management.LibraryManagementApplication.Service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/Members")
//public class MemberController {
//    @Autowired
//    MemberService memberService;
//
//            @Autowired
//    MemberRepository memberRepository;
//
//    @GetMapping("/get")
//    public List<Members> all(){
//        return memberRepository.findAll();
//    }
//
//    @PutMapping("/update/{id}")
//    public Members updatename(@PathVariable("id") int id, @RequestBody Members updatemember) {
//        var a = memberRepository.findById(id);
//        if (a.isPresent()) {
//            var b = a.get();
//            b.setFullname(updatemember.getFullname());
//            b.setEmail(updatemember.getEmail());
//            memberRepository.save(b);
//            return b;
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id not found");
//        }
//    }
//    @PostMapping("/create")
//    public ResponseEntity<MemberDto> create(@RequestBody MemberDto memberDto) {
//        MemberDto  membersDto = memberService.create(memberDto);
//        return ResponseEntity.status(HttpStatus.CREATED).body(membersDto);
//    }
//
//
//
//
//}
