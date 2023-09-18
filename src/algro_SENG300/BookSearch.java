package algro_SENG300;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookSearch { //TODO: This class must test all methods in linear and binary search 

	
	//////// LINEAR SEARCH ///////////////
	
    public static Book linearSearchBookID(List<Book> books, int key) {
        for (Book book : books) {
            if (book.getBookId() == key) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    
    public static Book linearSearchISBN(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getIsbn().equals(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    public static Book linearSearchOGTitle(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getOriginalTitle().equalsIgnoreCase(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    public static Book linearSearchAuthor(List<Book> books, String key) {
        for (Book book : books) {
            if (book.getAuthors().equalsIgnoreCase(key)) {
                return book; // Return the found book
            }
        }
        return null; // Return null if the book is not found
    }
    
    
    ///////////// BINARY SEARCH //////////////
    
    
    public static Book binarySearchBookID(List<Book> books, int key) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
        	
        	//Finds the middle index
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int midBookId = midBook.getBookId();

            if (midBookId == key) {
                return midBook; // Found the book in the middle itself
            } else if (midBookId < key) {
                left = mid + 1; // Search the right half if its not in the middle
            } else {
                right = mid - 1; // Search the left half if its not in the right for middle
            }
        }

        return null; 
    }
    
    public static Book binarySearchISBN(List<Book> books, String key) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
        	
        	//Finds the middle index
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            String midBookIsbn = midBook.getIsbn();

            if (midBookIsbn.equals(key)) {
                return midBook; 
            } else if (midBookIsbn.equals(key)) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return null; 
    }
    
    public static Book binarySearchTitle(List<Book> books, String key) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            String midBookTitle = midBook.getOriginalTitle();

            if (midBookTitle.equalsIgnoreCase(key)) {
                return midBook; 
            } else if (midBookTitle.equalsIgnoreCase(key)) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return null; 
    }
    
    public static Book binarySearchAuthor(List<Book> books, String key) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            String midBookAuthor = midBook.getAuthors();

            if (midBookAuthor.equalsIgnoreCase(key)) {
                return midBook; 
            } else if (midBookAuthor.equalsIgnoreCase(key)) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return null; 
    }

    
    
    public static void main(String[] args) {
        try {
        	BookSearch mySearch = new BookSearch();
            List<Book> books = Book_FileReader.readCSV(); // Load books from CSV

            String searchKey = "john green"; // Searching for a book with ID 2
            Book foundBook =  binarySearchAuthor(books, searchKey); //takes in the list of books and the bookid 

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