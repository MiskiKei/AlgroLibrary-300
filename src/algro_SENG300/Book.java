package algro_SENG300;

public class Book {
    private int bookId;
	private int goodreadsBookId;
    private int bestBookId;
    private int workId;
    private int booksCount;
    private String isbn;
    private String isbn13;
    private String authors;
    private int originalPublicationYear;
    private String originalTitle;
    private String title;
    private String languageCode;
    private double averageRating;
    private int ratingsCount;
    private int workRatingsCount;
    private int workTextReviewsCount;
    private int ratings1;
    private int ratings2;
    private int ratings3;
    private int ratings4;
    private int ratings5;
    private String imageUrl;
    private String smallImageUrl;

    // Constructors

    public Book(int bookId, int goodreadsBookId, int bestBookId, int workId, int booksCount, String isbn,
                String isbn13, String authors, int originalPublicationYear, String originalTitle, String title,
                String languageCode, double averageRating, int ratingsCount, int workRatingsCount,
                int workTextReviewsCount, int ratings1, int ratings2, int ratings3, int ratings4, int ratings5,
                String imageUrl, String smallImageUrl) {
        this.bookId = bookId;
        this.goodreadsBookId = goodreadsBookId;
        this.bestBookId = bestBookId;
        this.workId = workId;
        this.booksCount = booksCount;
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.authors = authors;
        this.originalPublicationYear = originalPublicationYear;
        this.originalTitle = originalTitle;
        this.title = title;
        this.languageCode = languageCode;
        this.averageRating = averageRating;
        this.ratingsCount = ratingsCount;
        this.workRatingsCount = workRatingsCount;
        this.workTextReviewsCount = workTextReviewsCount;
        this.ratings1 = ratings1;
        this.ratings2 = ratings2;
        this.ratings3 = ratings3;
        this.ratings4 = ratings4;
        this.ratings5 = ratings5;
        this.imageUrl = imageUrl;
        this.smallImageUrl = smallImageUrl;
    }
    
    //Setters and Getters


    public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getGoodreadsBookId() {
		return goodreadsBookId;
	}

	public void setGoodreadsBookId(int goodreadsBookId) {
		this.goodreadsBookId = goodreadsBookId;
	}

	public int getBestBookId() {
		return bestBookId;
	}

	public void setBestBookId(int bestBookId) {
		this.bestBookId = bestBookId;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getBooksCount() {
		return booksCount;
	}

	public void setBooksCount(int booksCount) {
		this.booksCount = booksCount;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public int getOriginalPublicationYear() {
		return originalPublicationYear;
	}

	public void setOriginalPublicationYear(int originalPublicationYear) {
		this.originalPublicationYear = originalPublicationYear;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}

	public int getWorkRatingsCount() {
		return workRatingsCount;
	}

	public void setWorkRatingsCount(int workRatingsCount) {
		this.workRatingsCount = workRatingsCount;
	}

	public int getWorkTextReviewsCount() {
		return workTextReviewsCount;
	}

	public void setWorkTextReviewsCount(int workTextReviewsCount) {
		this.workTextReviewsCount = workTextReviewsCount;
	}

	public int getRatings1() {
		return ratings1;
	}

	public void setRatings1(int ratings1) {
		this.ratings1 = ratings1;
	}

	public int getRatings2() {
		return ratings2;
	}

	public void setRatings2(int ratings2) {
		this.ratings2 = ratings2;
	}

	public int getRatings3() {
		return ratings3;
	}

	public void setRatings3(int ratings3) {
		this.ratings3 = ratings3;
	}

	public int getRatings4() {
		return ratings4;
	}

	public void setRatings4(int ratings4) {
		this.ratings4 = ratings4;
	}

	public int getRatings5() {
		return ratings5;
	}

	public void setRatings5(int ratings5) {
		this.ratings5 = ratings5;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
}
