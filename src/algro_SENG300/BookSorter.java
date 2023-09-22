package algro_SENG300;

import java.io.IOException;
import java.util.List;

public class BookSorter {

    // Static method to sort books by author's name in ascending order using selection sort
    public static List<Book> sortByAuthorAscending(List<Book> books) {
        int n = books.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (books.get(j).getAuthors().compareTo(books.get(minIndex).getAuthors()) < 0) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // Swap books at minIndex and i
                Book temp = books.get(i);
                books.set(i, books.get(minIndex));
                books.set(minIndex, temp);
            }
        }

        return books;
    }

    // Static method to sort books by author's name in descending order using selection sort
    public static List<Book> sortByAuthorDescending(List<Book> books) {
        int n = books.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (books.get(j).getAuthors().compareTo(books.get(maxIndex).getAuthors()) > 0) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                // Swap books at maxIndex and i
                Book temp = books.get(i);
                books.set(i, books.get(maxIndex));
                books.set(maxIndex, temp);
            }
        }

        return books;
    }

    // Static method to sort books by publication year in ascending order using selection sort
    public static List<Book> sortByPublicationYearAscending(List<Book> books) {
        int n = books.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (books.get(j).getOriginalPublicationYear() < books.get(minIndex).getOriginalPublicationYear()) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // Swap books at minIndex and i
                Book temp = books.get(i);
                books.set(i, books.get(minIndex));
                books.set(minIndex, temp);
            }
        }

        return books;
    }

    // Static method to sort books by publication year in descending order using selection sort
    public static List<Book> sortByPublicationYearDescending(List<Book> books) {
        int n = books.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (books.get(j).getOriginalPublicationYear() > books.get(maxIndex).getOriginalPublicationYear()) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                // Swap books at maxIndex and i
                Book temp = books.get(i);
                books.set(i, books.get(maxIndex));
                books.set(maxIndex, temp);
            }
        }

        return books;
    }
}



/*
 * public static void main(String[] args) { try { List<Book> books2 =
 * Book_FileReader.readCSV();
 * 
 * // // Sort the books by author in ascending order
 * BookSorter.sortByAuthorAscending(books2);
 * 
 * // Display the sorted books
 * System.out.println("Books sorted by author in ascending order:"); for (Book
 * book : books2) { System.out.println(book.getAuthors() + ": " +
 * book.getOriginalTitle()); }
 * 
 * // Sort the books by author in descending order
 * BookSorter.sortByAuthorDescending(books2);
 * 
 * // Display the sorted books
 * System.out.println("\nBooks sorted by author in descending order:"); for
 * (Book book : books2) { System.out.println(book.getAuthors() + ": " +
 * book.getOriginalTitle()); } } catch (IOException e) { e.printStackTrace(); }}
 * 
 * }
 */







