package LibraryManagementSystem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;



public class FileManager {
	
	
	

    // Saves all books, using the format Book.toFileString() already creates
    public void saveBooks(List<Book> books) throws IOException {
        try (PrintWriter out = new PrintWriter(
                new OutputStreamWriter(new FileOutputStream("books.txt"), StandardCharsets.UTF_8))) {
            for (Book b : books) {
                out.println(b.toFileString());
            }
        }
    }

    // Reads books back. Needs the list of authors to link each book to its author.
    public List<Book> loadBooks(List<Author> authors) throws IOException {
        List<Book> books = new ArrayList<>();
        File file = new File("books.txt");
        if (!file.exists()) {
            return books;
        }
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] p = line.split("\\|");
                int authorId = Integer.parseInt(p[2]);
                Author author = null;
                for (Author a : authors) {
                    if (a.getId() == authorId) {
                        author = a;
                    }
                }
                books.add(new Book(p[0], p[1], author,
                        Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5])));
            }
        }
        return books;
    } // Nayef's part saveBooks(List<Book> books): 
    //writes every book to books.txt using toFileString()
    // loadBooks(List<Author> authors): 
   // reads books.txt and rebuilds each book, linking it to its author by ID
}
//  left: 
//saveMembers / loadMembers
//saveRecords / loadRecords