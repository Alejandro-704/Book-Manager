package Final_Project;
/**
 * Interface for book class
 * @author Alejandro Montoya
 * 4/2/24
 */
public interface BookInterface {
    
    /**
     * Set the title for a book
     * @param title A string that is the name of a book
     */
    public void setTitle(String title);

    /**
     * Returns the title of a book
     * @return A string that is the given title of a book
     */
    public String getTitle();

    /**
     * Set the author of a book
     * @param author A string that is the name of the author of a book
     */
    public void setAuthor(Name author);

    /**
     * Returns the author of a book
     * @return Name object containing the author of a book.
     */
    public String getAuthor();

    /**
     * Set the price of a book
     * @param price A double that is the price of a book
     */
    public void setPrice(Double price);

    /**
     * Returns the price of a book
     * @return Double containing the price of the book
     */
    public Double getPrice();

    /**
     * Set the release year of a book
     * @param releaseYear An int that is the release year of a book
     */
    public void setReleaseYear(int releaseYear);

    /**
     * Returns the release year of a book
     * @return Int containing the release year of a book
     */
    public int getReleaseYear();

    /**
     * Set the page count of a book
     * @param pageCount The page count of a book
     */
    public void setPageCount(int pageCount);

    /**
     * Returns the page count of the desired book
     * @return The page count of a book
     */
    public int getPageCount();

    /**
     * Set a boolean value representing whether the book has been read or not
     * @param read True if read, false if not
     */
    public void setRead(boolean read);

    /**
     * Returns true if the book has been read and false if it has not
     * @return True or false
     */
    public String getRead();

    /**
     * Set a boolean value representing whether the book is a favorite or not
     * @param favorite True if favorite, false if not
     */
    public void setFavorite(boolean favorite);

    /**
     * Returns true if the book is a favorite, false if otherwise
     * @return True or false
     */
    public String getFavorite();
}
