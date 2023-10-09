package com.library.management.LibraryManagementApplication.Repository;

import com.library.management.LibraryManagementApplication.Entity.LibraryManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LibraryManagerRepository extends JpaRepository<LibraryManager,Integer> {



    @Query(value = "select * from library_manager where Snum=:snum", nativeQuery = true)
    LibraryManager findmemberbysnum(@Param("snum") int snum);

}
