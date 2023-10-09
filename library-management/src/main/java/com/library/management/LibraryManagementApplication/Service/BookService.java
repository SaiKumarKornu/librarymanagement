package com.library.management.LibraryManagementApplication.Service;

import com.library.management.LibraryManagementApplication.Dto.BooksDto;
import com.library.management.LibraryManagementApplication.Entity.Books;
import com.library.management.LibraryManagementApplication.Exceptions.ObjectNotValid;
import com.library.management.LibraryManagementApplication.Repository.BooksRepository;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BooksRepository booksRepository;


    public BooksDto updatebook(int id, BooksDto bookDto) {
        Books books = booksRepository.findbookbyid(id);
        if (bookDto == null) {
            throw new ObjectNotValid("id is not present");
        } else {
            books.setStatus(bookDto.getStatus());
            booksRepository.save(books);
            return new BooksDto(books);
        }
    }


    public BooksDto create(BooksDto booksDto) {
        if (booksDto == null) {
            throw new ObjectNotValid("Mention the details");
        } else {
            Books books=new Books();
            books.setBookname(booksDto.getBookname());
            books.setBookauthor(booksDto.getBookauthor());
            books.setStatus(booksDto.getStatus());
            booksRepository.save(books);
            return new BooksDto(books);
        }
    }


    public void generateExcel(HttpServletResponse response) throws Exception {

        List<Books> books = booksRepository.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Books Info");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("Book_id");
        row.createCell(1).setCellValue("Book_name");
        row.createCell(2).setCellValue("Book_author");
        row.createCell(2).setCellValue("Status");

        int dataRowIndex = 1;

        for (Books bookss : books) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(bookss.getBookid());
            dataRow.createCell(1).setCellValue(bookss.getBookname());
            dataRow.createCell(2).setCellValue(bookss.getBookauthor());
            dataRow.createCell(3).setCellValue(String.valueOf(bookss.getStatus()));
            dataRowIndex++;
        }

        ServletOutputStream sops = response.getOutputStream();
        workbook.write(sops);
        workbook.close();
        sops.close();

    }


}
