package algro_SENG300;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Book_FileReader {
	
    public static List<Book> readCSV() throws IOException {
    	
        List<Book> books = new ArrayList<>();
        
        String csvPattern = ",(?=(?:[^\"]*\"[^\"]*\")*(?![^\"]*\"))";

        try (BufferedReader br = new BufferedReader(new FileReader("src/bookSample.csv"))) {
            String line;
            // Skip the header line if present
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(csvPattern);
                if (fields.length == 23) { // Check if all fields are present
                    Book book = createBookFromFields(fields); //This is where you are able to insert the new book details into the list
                    books.add(book);
                } else {
                    System.out.println("Incomplete data for a book. Skipping line: " + line);
                }
            }
        }

        return books;
    }

    private static Book createBookFromFields(String[] fields) {
        int bookId = Integer.parseInt(fields[0]);
        int goodreadsBookId = Integer.parseInt(fields[1]);
        int bestBookId = Integer.parseInt(fields[2]);
        int workId = Integer.parseInt(fields[3]);
        int booksCount = Integer.parseInt(fields[4]);
        String isbn = fields[5];
        String isbn13 = fields[6];
        String authors = fields[7];
        double originalPublicationYear = Double.parseDouble(fields[8]);
        String originalTitle = fields[9];
        String title = fields[10];
        String languageCode = fields[11];
        double averageRating = Double.parseDouble(fields[12]);
        int ratingsCount = Integer.parseInt(fields[13]);
        int workRatingsCount = Integer.parseInt(fields[14]);
        int workTextReviewsCount = Integer.parseInt(fields[15]);
        int ratings1 = Integer.parseInt(fields[16]);
        int ratings2 = Integer.parseInt(fields[17]);
        int ratings3 = Integer.parseInt(fields[18]);
        int ratings4 = Integer.parseInt(fields[19]);
        int ratings5 = Integer.parseInt(fields[20]);
        String imageUrl = fields[21];
        String smallImageUrl = fields[22];

        return new Book(bookId, goodreadsBookId, bestBookId, workId, booksCount, isbn, isbn13, authors,
            originalPublicationYear, originalTitle, title, languageCode, averageRating, ratingsCount,
            workRatingsCount, workTextReviewsCount, ratings1, ratings2, ratings3, ratings4, ratings5,
            imageUrl, smallImageUrl);
    }


 /*   public static void main(String[] args) {
        try {
            List<Book> books = Book_FileReader.readCSV();

            // Display the top 10 books
            int limit = Math.min(10, books.size());
            for (int i = 0; i < limit; i++) {
                Book book = books.get(i); // Get the current book
                System.out.println(book.getAuthors() + "," + book.getOriginalTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } */
}
