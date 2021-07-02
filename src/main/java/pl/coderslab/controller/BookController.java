package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.MockBookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;
@Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @RequestMapping
    public List<Book> listOfBooks(){
        return this.mockBookService.showBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
    this.mockBookService.addBook(book);

    }
    @GetMapping("/{id}")
    public Book showBook(@PathVariable long id){
        return this.mockBookService.showBook(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
    this.mockBookService.deleteBook(id);
    }
    @PutMapping
    public void updateBook(@RequestBody Book book){
    this.mockBookService.updateBook(book);

    }




}
