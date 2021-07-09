package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.service.BookService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/books")
public class ManageBookController {

    private final BookService bookService;

@Autowired
    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBook(@ModelAttribute("book") Book book) {
        return "/books/add";
    }
    @PostMapping("/add")
    public String addPostBook(Book book) {
    bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteGet(@PathVariable long id, Model model){
    Book book = bookService.findBookById(id);
    model.addAttribute("book",book);
        return "/books/delete";
    }

    @PostMapping("/delete/{id}")
    public String deletePost(@RequestParam long id){
        bookService.deleteBook(id);
        return "redirect:/admin/books/all";
    }

    @GetMapping(value = "/{id}",produces = "text/html;charset=utf8" )
    @ResponseBody
    public String showBook(@PathVariable long id){
    return bookService.findBookById(id).toString() + "<br> " + "<p><a href=\"/admin/books/all\">Powrót</a><p>";
    }
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id,Model model) {
    Book book = bookService.findBookById(id);
    model.addAttribute("book",book);
        return "/books/edit";
    }
    @PostMapping("/edit/{id}")
    public String editPostBook(Book book) {
        bookService.addBook(book);
        return "redirect:/admin/books/all";
    }

}
