package com.library.management.LibraryManagementApplication.Repository;

import com.library.management.LibraryManagementApplication.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByName(String name);

   // List<UserInfo> getuserdetails(String username);
    @Query("select u.name from UserInfo u where u.name=:name")
    List<UserInfo> getuserdetails(@Param("name") String name);


    //  List<String> getuserdetails(String username);
}
