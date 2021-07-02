package pl.coderslab.service;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
@Getter
@ToString
@Component
@EqualsAndHashCode
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MockBookService {
    private List<Book> list;
    private static Long nextId = 4L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> showBooks(){

        return this.list;
    }
    public void addBook(Book item) {
        item.setId(nextId);
        this.list.add(item);
        nextId++;
    }
    public Book showBook(long index){
        for (Book el:list) {
            if (el.getId() ==index){
                return el;
            }
        }
        return null;
    }
    public void deleteBook(long index){
        for (Book el:list) {
            if (el.getId()==index){
                this.list.remove(el);
            }
        }


    }
    public void updateBook(Book item){
        for (Book el:list) {
            if (el.getId().equals(item.getId())){
                this.list.set(list.indexOf(el),item);
            }
        }
//        long lo = .getId();
//        int id = (int)lo;
//        this.list.set(id,item);
    }




}
