package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> get(long id);
    public List<Book> getBooks();
    public void addBook(Book item);
//    public Book showBook(long index);
    public void deleteBook(long index);
    public void updateBook(Book item);
    Book findBookById(long id);
}
