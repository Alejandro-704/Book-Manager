package Final_Project;

import java.util.Scanner;

public interface BookListInterface {
    /**
     * Add a book to the bookList
     * @param b A book object
     */
    public void addBook(Book b);

    /**
     * Add a book the the bookList in a specific place in the list
     * @param p Place in the list
     * @param b A book object
     */
    public void addbook(int p, Book b);

    /**
     * Remove a book from bookList by a given title
     * @param t Title of book
     */
    public void removeBookByTitle(String t);

    /**
     * Prints all books in bookList
     */
    public void getAllEntries();

    /**
     * Get a specific book by given title
     * @param t Title of a book object
     */
    public void getByTitle(String t);

    /**
     * Get a specific book by given Author
     * @param a Author of a book object
     */
    public void getByAuthor(String a);

    /**
     * Get a range of books by a given price range
     * @param minP Minimum price for range
     * @param maxP Maximum price for range
     */
    public void getbyPriceRange(Double minP, Double maxP);

    /**
     * Get a specific book by its given release year
     * @param RY The release year of a book object
     */
    public void getByReleaseYear(int RY);

    /**
     * Get specific books by a given range of release years
     * @param releaseYearMin
     * @param releaseYearMax
     */
    public void getByReleaseYearRange(int releaseYearMin, int releaseYearMax);

    /**
     * Get a range of books by a given page count range
     * @param minPC Minimum number of pages for range
     * @param maxPC Maximum number of pages for range
     */
    public void getByPageCountRange(int minPC, int maxPC);

    /**
     * Get a books by whether or not they been read
     */
    public void getByRead(String readStatus);

    /**
     * Get a books by whether or not they are favorites
     * @param f boolean value for whether or not the books are favorites
     */
    public void getByFavorite(String favoriteStatus);

    /**
     * Takes a book object selected by the user to possibly update price, to be read, and favorites.
     * @param book The title of the book that is to be updated
     */
    public void updateBook(String book, Scanner sc);

    /**
     * Writes the contents of the book collection to a file saving it for later use
     */
    public void writeToFile();
}
