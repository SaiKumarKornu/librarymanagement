package com.library.management.LibraryManagementApplication.Service;

import com.library.management.LibraryManagementApplication.Dto.LibraryManagerDto;
import com.library.management.LibraryManagementApplication.Entity.LibraryManager;
import com.library.management.LibraryManagementApplication.Exceptions.NoUsersFoundException;
import com.library.management.LibraryManagementApplication.Exceptions.ObjectNotValid;
import com.library.management.LibraryManagementApplication.Repository.LibraryManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryManagerService {

    @Autowired
    LibraryManagerRepository libraryManagerRepository;

    public LibraryManagerDto create(LibraryManagerDto libraryManagerDto) {
        if (libraryManagerDto == null) {
            throw new ObjectNotValid("Mention the details");
        } else {
            LibraryManager libraryManager = new LibraryManager();
            libraryManager.setBookid(libraryManagerDto.getBookid());
            libraryManager.setBorroweddate(libraryManagerDto.getBorroweddate());
            libraryManager.setReturndate(libraryManagerDto.getReturndate());
            libraryManager.setUserid(libraryManagerDto.getUserid());
            libraryManagerRepository.save(libraryManager);
            return new LibraryManagerDto(libraryManager);
        }
    }

    public LibraryManagerDto delete(int snum) {
            LibraryManager libraryManager = libraryManagerRepository.findmemberbysnum(snum);
            if (libraryManager == null) {
                throw new NoUsersFoundException("snum is not present");
            } else {
                libraryManagerRepository.delete(libraryManager);
                return new LibraryManagerDto(libraryManager);
            }

        }

}
