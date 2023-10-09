package com.library.management.LibraryManagementApplication.Dto;

import com.library.management.LibraryManagementApplication.Entity.Books;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
//@NoArgsConstructor
public class BooksDto {


    private int bookid;
    private String bookname;
    private String bookauthor;
private  String status;

    //private Status status;

    public BooksDto(Books books) {
        this.bookid = books.getBookid();
        this.bookname = books.getBookname();
        this.bookauthor = books.getBookauthor();
        this.status = books.getStatus();
    }

    public BooksDto() {
    }
}
