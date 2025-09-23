package Final_Project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * Book list class
 * @author Alejandro Montoya
 */
public class BookList implements BookListInterface {

    private List<Book> books;

    public BookList(){
        books = new ArrayList<>();
    } // End of constructor

    public void addBook(Book b) {
        books.add(b);
        
    } // End of addBook by book object

    public void addbook(int p, Book b) {
       books.add(p, b);
       
    } // End of addBook by position and book object

    public void removeBookByTitle(String t) {
        int length = books.size();
        boolean itemFound = false;
        int i = 0;
        try {
            while (books.size() == length) {
                if (books.get(i).getTitle().equalsIgnoreCase(t)) {
                    books.remove(i);
                    itemFound = true;
                }
                i++;

                if (!itemFound) {
                    System.out.println("Book \"" + t + "\" was not found in the collection.");
                    break;
                } else {
                    System.out.println("Book " + t + " was succesfully removed.");
                    break;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error ocurred, try again.");
        } catch (Exception e) {
            System.out.println(e);
        }
        
    } // Endo fo removeBookByTitle

    public void getAllEntries() {
        int length = books.size();
        if (books.isEmpty()) {
            System.out.println("There are no books.");
        } else {
            for (int i = 0; i < length; i++) {
                System.out.println("Book #: " + (i+1));
                System.out.println(books.get(i));
            }
        }
    } // End of getAllEntries

    public void getByTitle(String t) {
        int length = books.size();
        boolean itemFound = false;
        for(int i = 0; i < length; i++){
            if (books.get(i).getTitle().equalsIgnoreCase(t)) {
                System.out.println(books.get(i));
                itemFound = true;
            }
        }
        if (!itemFound) {System.out.println("Book \"" + t + "\" was not found in the collection.");}
    } // End of getByTitle

    public void getByAuthor(String a) {
        int length = books.size();
        boolean itemFound = false;
        for(int i = 0; i < length; i++){
            if (books.get(i).getAuthor().equalsIgnoreCase(a)) {
                System.out.println(books.get(i));
                itemFound = true;
            }
        }
        if (!itemFound) {System.out.println("Author \"" + a + "\" was not found in the collection.");}
    } // End of getByAuthor

    public void getbyPriceRange(Double minP, Double maxP) {
        int length = books.size();
        boolean itemFound = false;
        for(int i = 0; i < length; i++){
            if (books.get(i).getPrice() >= minP && books.get(i).getPrice() <= maxP) {
                System.out.println(books.get(i));
                itemFound = true;
            }
        }
        if (!itemFound) {System.out.println("No books found within the given price range.");}
    } // End of getbyPriceRange

    public void getByReleaseYear(int RY) {
        int length = books.size();
        for(int i = 0; i < length; i++) {
            if (books.get(i).getReleaseYear() == RY) {
                System.out.println(books.get(i));
            }
        }
    } // End of getByReleaseYear

    public void getByReleaseYearRange(int ryMin, int ryMax) {
        int length = books.size();
        boolean itemFound = false;
        for (int i = 0; i < length; i++) {
            if (books.get(i).getReleaseYear() > ryMin && books.get(i).getReleaseYear() < ryMax) {
                System.out.println(books.get(i));
                itemFound = true;
            }
        }
        if (!itemFound) {System.out.println("No books found within the given year range");}
    } // End of getByReleaseYearRange

    public void getByPageCountRange(int minPC, int maxPC) {
        int length = books.size();
        boolean itemFound = false;
        for(int i = 0; i < length; i++){
            if (books.get(i).getPageCount() >= minPC && books.get(i).getPageCount() <= maxPC) {
                System.out.println("Books in the given page count range: \n");
                System.out.println(books.get(i));
            }
        }
        if(!itemFound) {System.out.println("No books found within the given page count range.");}
    } // End of getByPageCountRange

    public void getByRead(String readStatus) {
        int length = books.size();
        boolean itemFound = false;
        int itemFoundCount = 0;
        for(int i = 0; i < length; i++) {
            if (books.get(i).getRead().equals(readStatus)) {
                System.out.println(books.get(i));
                itemFound = true;
                itemFoundCount++;
            }
        }
        if (!itemFound) {
            System.out.println("All boooks have been read");
        } else if (itemFoundCount == length) {
            System.out.println("No books have been read.");
        }
    } // End of getByRead

    public void getByFavorite(String readStatus) {
        int length = books.size();
        boolean itemFound = false;
        for(int i = 0; i < length; i++) {
            if (books.get(i).getFavorite().equals(readStatus)) {
                System.out.println(books.get(i));
                itemFound = true;
            }
        }
        if (!itemFound) {
            System.out.println("There are no favorite books.");
        }
    } // End of getByFavorite

    public void updateBook(String bookTitle, Scanner sc) {
        //Scanner updates = new Scanner(System.in);
        
        boolean found = false;
        Book bookToUpdate = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                found = true;
                bookToUpdate = book;
                break;
            }
        }

        if (found) {
            System.out.println("What about \"" + bookTitle + "\" would you like to update?\n"
                    + "1. Update price\n"
                    + "2. Update reading status\n"
                    + "3. Update favorite status\n0. Exit");

                    System.out.print("Option #: ");
                    int updateChoice = sc.nextInt();
                    sc.nextLine();
            switch (updateChoice) {
                case 1: // Update price
                    try {
                        System.out.print("Updating price.\nEnter new price: ");
                        double newPrice = sc.nextDouble();
                        bookToUpdate.setPrice(newPrice);
                        System.out.println("Price updated succesfully.");
                    } catch (InputMismatchException e) {
                        System.out.println("Incorrect input.");
                        sc.nextLine();
                    }
                    break;

                case 2: // Update reading status
                    System.out.print("Updating reading status."
                    + "\nEnter \"Yes\" if you've finished the book, otherwise enter \"No\": ");
                    String readingUpdate = sc.next();
                    bookToUpdate.setRead(readingUpdate.equalsIgnoreCase("Yes"));
                    System.out.println("Reading status updated succesfully.");
                    break;

                case 3: // Reading favorite status
                    System.out.print("Updating favorite status.\nCurrent favorite status: " + bookToUpdate.getFavorite()
                    + "\nEnter \"Yes\" if this book is one of your favorites, otherwise enter \"No\": ");
                    String favUpdate = sc.next();
                    bookToUpdate.setFavorite(favUpdate.equalsIgnoreCase("Yes"));
                    System.out.println("Favorite status updated succesfully.");
                    break;
            
                case 0: 
                    System.out.println("Exit.");
                    break;
                
                default:
                    System.out.println("Wrong input.");
                    break;
            }
        } else {
            System.out.println("Book " + bookTitle + " not found.");
        }
        //updates.close();
    }
    
    public void writeToFile() {
        try (FileWriter writeToFile = new FileWriter("Final_Project\\BOOK_SHELVE.txt")) {
            for (Book book : books) {
                writeToFile.write(String.format("%s,%s,%.2f,%d,%d,%s,%s%n", book.getTitle(), book.getAuthor(), 
                book.getPrice(), book.getReleaseYear(), book.getPageCount(), book.getRead(), book.getFavorite()));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.\n" + e);
        }
        System.out.println("Collection updated.");
    }
}
