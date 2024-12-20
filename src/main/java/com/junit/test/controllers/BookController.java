package com.junit.test.controllers;

import com.junit.test.entities.Book;
import com.junit.test.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

      @Autowired
      BookRepository bookRepository;

      @GetMapping
      public List<Book> getALlBooks() {
          return bookRepository.findAll();
      }

      @GetMapping("/{bookId}")
      public Book getBookById(@PathVariable Long bookId) {
          return bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book with given id not found"));
      }

      @PostMapping
      public Book createBook(@RequestBody Book book) {
          return bookRepository.save(book);
      }

      @PutMapping("/{bookId}")
      public Book updateBook(@PathVariable Long bookId, @RequestBody Book book) {
          Book book1 = bookRepository.findById(bookId).get();
          book1.setName(book.getName());
          book1.setSummary(book.getSummary());
          book1.setRating(book.getRating());

          return bookRepository.save(book1);
      }

      // delete endpoint using TDD method
      @DeleteMapping("/{bookId}")
      public void deleteBookById(@PathVariable Long bookId) throws NotFoundException {
          if(!bookRepository.findById(bookId).isPresent()) {
            throw new NotFoundException();
          }
            bookRepository.deleteById(bookId);
      }

    
    

    


}
