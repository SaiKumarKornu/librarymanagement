package com.library.management.LibraryManagementApplication.Repository;

import com.library.management.LibraryManagementApplication.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends JpaRepository<Books,Integer> {

    @Query(value="select * from books WHERE Book_id =:bId ;",nativeQuery = true)
    Books findbookbyid(@Param("bId") int bId);

}
