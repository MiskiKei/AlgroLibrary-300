package algro_SENG300;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookSearch { //TODO: This class must test all methods in linear and binary search 

    private static Book linearSearchBookID(List<Book> books, int key) {
        for (Book book : books) {
            if (book.getBookId() == key) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    
    private static Book linearSearchISBN(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getIsbn().equals(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    private static Book linearSearchOGTitle(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getOriginalTitle().equalsIgnoreCase(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    private static Book linearSearchAuthor(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getAuthors().equalsIgnoreCase(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }

    
    
    
    public static void main(String[] args) {
        try {
            List<Book> books = Book_FileReader.readCSV(); // Load books from CSV

            String searchKey = "Gillian Flynn"; // Searching for a book with ID 2
            Book foundBook = linearSearchAuthor(books, searchKey); //takes in the list of books and the bookid 

            if (foundBook != null) {
                System.out.println("Book found: " + foundBook.getBookId() + ", " + foundBook.getTitle());
            } else {
                System.out.println("Book not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}