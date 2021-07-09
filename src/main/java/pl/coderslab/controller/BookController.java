package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;
import java.util.List;

//@RestController
//@RequestMapping("/books")
public class BookController {
    private BookService bookService;
//@Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }
    @RequestMapping
    public List<Book> listOfBooks(){
        return this.bookService.getBooks();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
    this.bookService.addBook(book);

    }
//    @GetMapping("/{id}")
//    public Book showBook(@PathVariable long id){
//        return this.bookService.showBook(id);
//    }
@GetMapping("/{id}")
public Book showBook(@PathVariable long id) {
    return this.bookService.get(id).orElseThrow(() -> {
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    });
}

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id){
    this.bookService.deleteBook(id);
    }
    @PutMapping
    public void updateBook(@RequestBody Book book){
    this.bookService.updateBook(book);

    }




}
