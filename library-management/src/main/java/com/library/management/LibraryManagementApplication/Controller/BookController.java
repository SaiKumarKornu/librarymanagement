package com.library.management.LibraryManagementApplication.Controller;

import com.library.management.LibraryManagementApplication.Dto.BooksDto;
import com.library.management.LibraryManagementApplication.Entity.Books;
import com.library.management.LibraryManagementApplication.Repository.BooksRepository;
import com.library.management.LibraryManagementApplication.Service.BookService;
import com.library.management.LibraryManagementApplication.jwtService.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;
@Autowired
    JwtService jwtService;
    @Autowired
    BooksRepository booksRepository;
    @GetMapping("/get")
    @PreAuthorize(("hasAnyAuthority('ROLE_ADMIN')"))
    public List<Books> all(){
        return booksRepository.findAll();
    }

    @PutMapping("/update")
    @PreAuthorize(("hasAnyAuthority('ROLE_ADMIN')"))
    public ResponseEntity<BooksDto> updatebook(@RequestParam("bookid") int bookid, @RequestBody BooksDto bookDto) {
        BooksDto booksDto = bookService.updatebook(bookid, bookDto);
        return ResponseEntity.status(HttpStatus.OK).body(booksDto);
    }

    @PostMapping("/create")
    @PreAuthorize(("hasAnyAuthority('ROLE_ADMIN')"))
    public ResponseEntity<BooksDto> create(@RequestBody BooksDto booksDto) {
        BooksDto  bookDto = bookService.create(booksDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }


    @GetMapping("/excel")
    public void generateExcelReport(HttpServletResponse response) throws Exception{

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=boks.xls";

        response.setHeader(headerKey, headerValue);

        bookService.generateExcel(response);

        response.flushBuffer();
    }

}
