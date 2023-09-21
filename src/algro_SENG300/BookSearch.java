package algro_SENG300;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
    
    public static long testLinearSearchBookID(List<Book> books, List<Integer> keys) {
        long startTime = System.currentTimeMillis();
        for (int key : keys) {
            Book result = linearSearchBookID(books, key);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testLinearSearchISBN(List<Book> books, List<String> keys) {
        long startTime = System.currentTimeMillis();
        for (String key : keys) {
            Book result = linearSearchISBN(books, key);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testBinarySearchBookID(List<Book> books, List<Integer> keys) {
        long startTime = System.currentTimeMillis();
        for (int key : keys) {
            Book result = binarySearchBookID(books, key);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long testBinarySearchISBN(List<Book> books, List<String> keys) {
        long startTime = System.currentTimeMillis();
        for (String key : keys) {
            Book result = binarySearchISBN(books, key);
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }



    
    
    public static void main(String[] args) throws IOException {
        List<Book> books = null;
        try {
            books = Book_FileReader.readCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (books != null) {
            int limit = Math.min(1000, books.size());
            List<Integer> specificBookIds = new ArrayList<>();
            specificBookIds.add(950);
            List<String> specificIsbns = new ArrayList<>();
            specificIsbns.add("451188462");

            for (int i = 0; i < limit; i++) {
                Book book = books.get(i);
                specificBookIds.add(book.getBookId());
                specificIsbns.add(book.getIsbn());
            }

            // Test linear search for Book IDs
            long linearSearchTimeBookId = BookSearch.testLinearSearchBookID(books, specificBookIds);
            System.out.println("Linear Search Time for Book IDs: " + linearSearchTimeBookId + " milliseconds");

            // Test linear search for ISBNs
            long linearSearchTimeIsbn = BookSearch.testLinearSearchISBN(books, specificIsbns);
            System.out.println("Linear Search Time for ISBNs: " + linearSearchTimeIsbn + " milliseconds");

            // Test binary search for Book IDs
            long binarySearchTimeBookId = BookSearch.testBinarySearchBookID(books, specificBookIds);
            System.out.println("Binary Search Time for Book IDs: " + binarySearchTimeBookId + " milliseconds");

            // Test binary search for ISBNs
            long binarySearchTimeIsbn = BookSearch.testBinarySearchISBN(books, specificIsbns);
            System.out.println("Binary Search Time for ISBNs: " + binarySearchTimeIsbn + " milliseconds");
        }
    }
}
   