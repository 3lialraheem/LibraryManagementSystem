package LibraryManagementSystem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Author extends Person{
    
	private String nationality;
    private final ArrayList<Book> authorBooks;
    public Author(int id, String name, String nationality) {
        super(id, name);
        this.nationality = nationality;
        this.authorBooks = new ArrayList<>();
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public List<Book> getBooks() {
        return Collections.unmodifiableList(authorBooks);
    }
    public void addBook(Book book) {
        if (book != null && !authorBooks.contains(book)) {
            authorBooks.add(book);
        }
    }
    public String toFileString() {
        return getId() + "|" + getName() + "|" + nationality;
    }
}
