package com.library.management.LibraryManagementApplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.management.LibraryManagementApplication.Dto.LibraryManagerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "library_manager")
@Data
@AllArgsConstructor
//@NoArgsConstructor
public class LibraryManager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Snum")
    private int snum;
    @Column(name = "user_id")
    private int userid;
    @Column(name = "book_id")
    private int bookid;

    @Column(name = "borrowed_date")
    private String borroweddate;
    @Column(name = "return_date")
    private String returndate;



    public LibraryManager(LibraryManagerDto libraryManagerDto) {
      //  this.snum = libraryManagerDto.getSnum();
        this.userid = libraryManagerDto.getUserid();
        this.bookid = libraryManagerDto.getBookid();
        this.borroweddate = libraryManagerDto.getBorroweddate();
        this.returndate = libraryManagerDto.getReturndate();
        this.books = books;
        this.users = users;
    }

    public LibraryManager() {
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Books books;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserInfo users;


}
