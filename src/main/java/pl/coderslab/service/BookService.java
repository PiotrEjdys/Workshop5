package pl.coderslab.service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {
    public List<Book> showBooks();
    public void addBook(Book item);
    public Book showBook(long index);
    public void deleteBook(long index);
    public void updateBook(Book item);
}
