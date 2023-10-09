package com.library.management.LibraryManagementApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.LibraryManagementApplication.Dto.BooksDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="books")
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class Books {

    @Id
    @Column(name="Book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookid;
    @Column(name="book_name")
    private String bookname;
    @Column(name = "book_author")
    private String bookauthor;



    @Column(name="status")
    private String status;
//    private Status status;

    public Books(BooksDto booksDto) {
        this.bookid = booksDto.getBookid();
        this.bookname = booksDto.getBookname();
        this.bookauthor = booksDto.getBookauthor();
        this.status=booksDto.getStatus();
//        this.library_management = library_management;
    }

    public Books() {
    }

    @OneToMany(mappedBy = "books")
    @JsonIgnore
    private List<LibraryManager> library_management;


    public Books(int i, String sai, String ytwfcvyd, String available) {
    }
}