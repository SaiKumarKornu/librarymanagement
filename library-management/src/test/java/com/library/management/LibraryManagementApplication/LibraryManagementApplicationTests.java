//package com.library.management.LibraryManagementApplication;
//
//import com.library.management.LibraryManagementApplication.Entity.Books;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.web.client.RestTemplate;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Disabled;
//@Disabled
//@ContextConfiguration
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class LibraryManagementApplicationTests {
//
//		@LocalServerPort
//		private int port;
//
//		private static String baseurl = "http://localhost";
//
//		@Autowired
//		TestRepository testRepository;
//		private static RestTemplate restTemplate;
//		@BeforeAll
//		public static void init () {
//			restTemplate = new RestTemplate();
//		}
//
//		@BeforeEach
//		public void setup() {
//			baseurl = baseurl.concat(":").concat(String.valueOf(port)).concat("/books");
//		}
//
////		@Test
////		public void testAddUser () {
////			UserInfo userInfo =new UserInfo(12,"varun", "varun@123", "9493469581", "varun", "ROLE_USER");
////			UserInfo response = restTemplate.postForObject(baseurl, userInfo, UserInfo.class);
////			assertEquals("varun",response.getName());
////			assertEquals(1,testRepository.findAll().size());
////		}
//
//	@Test
//	public void testAddBook () {
//		Books books =new Books(10,"Sai","ytwfcvyd","Available");
//		Books response = restTemplate.postForEntity(baseurl, books, Books.class).getBody();
//		assertEquals("sai",response.getBookauthor());
//		assertEquals(3,testRepository.findAll().size());
//	}
//	}