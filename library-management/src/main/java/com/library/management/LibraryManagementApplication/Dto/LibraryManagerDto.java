package com.library.management.LibraryManagementApplication.Dto;

import com.library.management.LibraryManagementApplication.Entity.LibraryManager;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class LibraryManagerDto {

 //   private int snum;
    private int bookid;
    private int userid;
    private String borroweddate;
    private String returndate;
    private String role;


    public LibraryManagerDto(LibraryManager libraryManager) {
     //   this.snum = libraryManager.getSnum();
        this.bookid = libraryManager.getBookid();
        this.userid = libraryManager.getUserid();
        this.borroweddate = libraryManager.getBorroweddate();
        this.returndate = libraryManager.getReturndate();

    }

    public LibraryManagerDto() {
    }
}
