package Final_Project;
/**
 * Book class
 * @author Alejandro Montoya
 */
public class Book implements BookInterface {

    // Base variables
    private String title;
    private Name author;
    private Double price;
    private int releaseYear;
    private int pageCount;
    private String read;
    private String favorite;
    
    public Book(){
    } // End of default constructor

    public Book(String bTitle, Name bAuthor, Double bPrice, int bReleaseYear, int bPageCount, boolean bRead, boolean bFavorite){
        title = bTitle;
        author = bAuthor;
        price = bPrice;
        releaseYear = bReleaseYear;
        pageCount = bPageCount;
        setRead(bRead);
        setFavorite(bFavorite);
    } // End of constructor

    public void setTitle(String bTitle) {
        title = bTitle;
    } // End of setTitle

    public String getTitle() {
        return title;
    } // End of getTitle

    public void setAuthor(Name bAuthor) {
        author = bAuthor;
    } // End of setAuthor

    public String getAuthor() {
        return author.getName();
    } // End of getAuthor

    public void setPrice(Double bPrice) {
        price = bPrice;
    } // End of setPrice

    public Double getPrice() {
        return price;
    } // End of getPrice

    public void setReleaseYear(int bReleaseYear) {
        releaseYear = bReleaseYear;
    } // End of setReleaseYear

    public int getReleaseYear() {
        return releaseYear;
    } // End of getReleaseYear

    public void setPageCount(int bPageCount) {
        pageCount = bPageCount;
    } // End of setPageCount

    public int getPageCount() {
        return pageCount;
    } // End of getPageCount

    public void setRead(boolean bRead) {
        if (bRead == true) {
            read = "Yes";
        } else {
            read = "No";
        }
    } // End of setRead

    public String getRead() {
        return read;
    } // End of getRead

    public void setFavorite(boolean bFavorite) {
        if (bFavorite == true) {
            favorite = "Yes";
        } else {
            favorite = "No";
        }
    } // End of setFavorite

    public String getFavorite() {
        return favorite;
    } // End of getFavorite
    
    public String toString() {
        String formattedPrice = String.format("%,.2f", price);

        return "================================\n"
        + "Book information:\n"
        + "Title: " + title + "\n"
        + "Author: " + author + "\n"
        + "Price: $" + formattedPrice + "\n"
        + "Release Year: " + releaseYear + "\n"
        + "Page Count: " + pageCount + "\n"
        + "Read? " + read + "\n"
        + "Favorite? " + favorite + "\n";

    } // End of toString
}
