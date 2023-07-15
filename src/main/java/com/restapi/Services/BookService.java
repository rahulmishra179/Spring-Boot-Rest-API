package com.restapi.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.Entities.Book;
import com.restapi.Repository.BookRepository;

@Component
public class BookService {

   // private static List<Book> list = new ArrayList<>();

   // static {
   //    list.add(new Book(1, "java", "Rahul"));
   //    list.add(new Book(2, "python", "sunny"));
   //    list.add(new Book(3, "c++", "aditya"));
   //    list.add(new Book(4, "reactJs", "pankaj"));
   //    list.add(new Book(5, "English", "Ravi"));

   // }
   @Autowired
   private BookRepository bookRepository;

   public List<Book> getAllBooks() {
      List<Book> book= (List<Book>)bookRepository.findAll();
      return book;
   }

   public Book getBookById(int id) {
      // Book book = null;
      // try {
      //    book = list.stream().filter(e -> e.getId() == id).findFirst().get();
      // } catch (Exception e) {
      //    e.printStackTrace();
      // }
      Book book= bookRepository.findById(id);
      return book;
   }

   public Book addBook(Book book) {
      // list.add(book);
      Book result = bookRepository.save(book);
      return result;
   }

   public void deleteBook(int bookId) {
      // list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
      bookRepository.deleteById(bookId);
   }

   public void updateBook(Book book, int bookId) {
      // list = list.stream().map(b -> {
      //    if (b.getId() == bookId) {
      //       b.setTitle(book.getTitle());
      //       b.setAuthor(book.getAuthor());
      //    }
      //    return b;
      // }).collect(Collectors.toList());
      book.setId(bookId);
      bookRepository.save(book);
   }

}
