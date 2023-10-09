package com.library.management.LibraryManagementApplication.Controller;

import com.library.management.LibraryManagementApplication.Dto.LibraryManagerDto;
import com.library.management.LibraryManagementApplication.Entity.LibraryManager;
import com.library.management.LibraryManagementApplication.Repository.LibraryManagerRepository;
import com.library.management.LibraryManagementApplication.Service.LibraryManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/LibraryManager")
public class LibraryManagerController {

    @Autowired
    LibraryManagerService libraryManagerService;

    @Autowired
    LibraryManagerRepository libraryManagerRepository;

    @GetMapping("/get")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<LibraryManager> all(){
        return libraryManagerRepository.findAll();
    }



    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<LibraryManagerDto> create(@RequestBody LibraryManagerDto libraryManagerDto) {
        LibraryManagerDto  libraryManagersDto = libraryManagerService.create(libraryManagerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(libraryManagersDto);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<LibraryManagerDto> remove(@RequestParam("snum") int snum) {
        LibraryManagerDto   libraryManagerDto = libraryManagerService.delete(snum);
        return ResponseEntity.status(HttpStatus.OK).body(libraryManagerDto);
    }

}
