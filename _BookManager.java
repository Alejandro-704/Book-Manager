package Final_Project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Create a list of books simulating a book shelve where you can add, remove and do other things with books in the collection
 * @author Alejandro Montoya
 * 4/12/24
 */

 // INPUT: Show the number of entry of each current book to make easier to understand when adding to a position
 // When updating, option 3 doesn't work
 // 

public class _BookManager {
    public static void main(String[] args) {
        BookListInterface bookList = new BookList();

        try {
            File file = new File("Final_Project\\BOOK_SHELVE.txt");
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNext()) {
                String line = fileReader.nextLine();

                String[] parts = line.split(",");

                //Since names go first last, split by space and make a name Object.
                String[] authorName = parts[1].split(" ");
                Name author = new Name(authorName[0], authorName[1]);

                // Parts are added from the text line in BOOK_SHELVE,
                // for Read and Favorite, if the string read is "Yes" ignoring case then True is assigned, otherwise its false.
                bookList.addBook(new Book(parts[0], author, Double.parseDouble(parts[2]),
                 Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                  parts[5].equalsIgnoreCase("Yes"), parts[6].equalsIgnoreCase("Yes")));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error found.");
            System.out.println(e);
        }

        System.out.println("Book Manager Program");

        // User scanner for user promts like title, author, release year, and ranges, etc.
        // Menu scanner for the menu options
        Scanner userScanner = new Scanner(System.in);
        Scanner menuScanner = new Scanner(System.in);

        int userInput = 1;
        do {
            try {
            //Menu
            displayMenu();
            userInput = menuScanner.nextInt();
            menuScanner.nextLine();
            
            switch (userInput) {
                case 1: //Get all entries option
                    System.out.println("================================");
                    System.out.println("All current books:");
                    bookList.getAllEntries();
                    break;
            
                case 2: // Get book by its title
                    System.out.println("================================");
                    System.out.print("Book by title.\nEnter title: ");
                    String title = userScanner.nextLine();
                    bookList.getByTitle(title);
                    break;

                case 3: // Get book by author
                    System.out.println("================================");
                    System.out.print("Book by author.\nEnter author: ");
                    String fullName = userScanner.nextLine();
                    bookList.getByAuthor(fullName);
                    break;

                case 4: // Get book(s) by price range
                        System.out.println("================================");
                        System.out.print("Book by price range.\nEnter minimum price: ");
                        double pMin = userScanner.nextDouble();
                        userScanner.nextLine();
                        System.out.print("Enter maximum price: ");
                        double pMax = userScanner.nextDouble();
                        userScanner.nextLine();
                        System.out.println("Books in the given price range:\n");
                        bookList.getbyPriceRange(pMin, pMax);
                        break;
                    

                case 5: // Get book by release year
                        System.out.println("================================");
                        System.out.print("Book by release year.\nEnter release year: ");
                        int releaseYear = userScanner.nextInt();
                        userScanner.nextLine();
                        bookList.getByReleaseYear(releaseYear);
                    
                    break;

                case 6: // Get book by release year range
                        System.out.println("================================");
                        System.out.print("Book by release year range.\nEnter minimum year: ");
                        int minY = userScanner.nextInt();
                        userScanner.nextLine();
                        System.out.print("Enter maximum year: ");
                        int maxY = userScanner.nextInt();
                        userScanner.nextLine();
                        System.out.println("Books in the given year range:\n");
                        bookList.getByReleaseYearRange(minY,maxY);
                        break;
                case 7: // Get by page count range
                        System.out.println("================================");
                        System.out.print("Book by page count range.\nEnter minimum page count: ");
                        int minPC = userScanner.nextInt();
                        userScanner.nextLine();
                        System.out.print("Enter maximum page count: ");
                        int maxPC = userScanner.nextInt();
                        userScanner.nextLine();
                        System.out.println("Books in the given page count range:\n");
                        bookList.getByPageCountRange(minPC, maxPC);
                        break;

                case 8: // Get books to be read
                    System.out.println("================================");
                    System.out.println("Books to be read...");
                    bookList.getByRead("No");
                    break;

                case 9: // Get already read books
                    System.out.println("================================");
                    System.out.println("Books read.");
                    bookList.getByRead("Yes");
                    break;

                case 10: // Get favorite books
                    System.out.println("================================");
                    System.out.println("Favorite books.");
                    bookList.getByFavorite("Yes");
                    break;

                case 11: // Add a book to collection/shelve
                    System.out.println("================================");
                    System.out.print("Adding new book.\nEnter title: ");
                    String newTitle = userScanner.nextLine();
                    System.out.print("Enter author's first name: ");
                    String newAuthorFirst = userScanner.nextLine();
                    System.out.print("Enter author's last name: ");
                    String newAuthorLast = userScanner.nextLine();
                    Name newName = new Name(newAuthorFirst, newAuthorLast);
                    System.out.print("Enter price: ");
                    Double newPrice = userScanner.nextDouble();
                    System.out.print("Enter release year: ");
                    int newReleaseYear = userScanner.nextInt();
                    System.out.print("Enter page count: ");
                    int newPageCount = userScanner.nextInt();
                    userScanner.nextLine();
                    System.out.print("Have you read this book? ");
                    String newRead = userScanner.nextLine();
                    System.out.print("Is this book a favorite? ");
                    String newFavorite = userScanner.nextLine();

                    //Creating book to be added to collection
                    bookList.addBook(new Book(newTitle, newName, newPrice, newReleaseYear, newPageCount,
                    newRead.equalsIgnoreCase("Yes"), newFavorite.equalsIgnoreCase("Yes")));
                    System.out.println("New book added to the collection.");
                    break;

                case 12: // Add a book to a specific position on the collection/shelve
                    System.out.println("================================");
                    System.out.print("Adding new book to a specific position.\nEnter title: ");
                    newTitle = userScanner.nextLine();
                    System.out.print("Enter author's first name: ");
                    newAuthorFirst = userScanner.nextLine();
                    System.out.print("Enter author's last name: ");
                    newAuthorLast = userScanner.nextLine();
                    newName = new Name(newAuthorFirst, newAuthorLast);
                    System.out.print("Enter price: ");
                    newPrice = userScanner.nextDouble();
                    System.out.print("Enter release year: ");
                    newReleaseYear = userScanner.nextInt();
                    System.out.print("Enter page count: ");
                    newPageCount = userScanner.nextInt();
                    userScanner.nextLine();
                    System.out.print("Have you read this book? ");
                    newRead = userScanner.nextLine();
                    System.out.print("Is this book a favorite? ");
                    newFavorite = userScanner.nextLine();
                    System.out.print("Do you want to see the current book list\n"
                    + "before selecting a position for the new book? ");
                    String selection = userScanner.nextLine();
                    //true if the argument is not null and it represents an equivalent String ignoring case; false otherwise
                    if (selection.equalsIgnoreCase("Yes")) {
                        bookList.getAllEntries();
                    }
                    System.out.print("Finally, enter the position the book should go in: ");
                    int newBookPos = userScanner.nextInt();
                    userScanner.nextLine();
                    // Creating book to be added to given position
                    bookList.addbook(newBookPos - 1, new Book(newTitle, newName, newPrice, newReleaseYear, newPageCount,
                    newRead.equalsIgnoreCase("Yes"), newFavorite.equalsIgnoreCase("Yes")));
                    System.out.println(newTitle + " was succesfully added to position " + newBookPos + " in the collection.");
                    break;

                case 13: // Remove book by title
                    System.out.println("================================");
                    System.out.print("Removing book by title.\nEnter title to remove: ");
                    String removeTitle = userScanner.nextLine();
                    bookList.removeBookByTitle(removeTitle);
                    break;

                case 14: // Update book
                    System.out.println("================================");
                    System.out.print("Updating book.\nEnter which book (by title) to update: ");
                    String bookToUpdate = userScanner.nextLine();
                    bookList.updateBook(bookToUpdate, userScanner);
                    break;

                case 0: // Exit
                    System.out.println("================================");
                    System.out.println("Exit.");
                    bookList.writeToFile();
                    break;

                default:
                    System.out.println("================================");
                    System.out.println("Incorrect input. Please try again.");
                    break;
            }
            } catch (InputMismatchException e) {
                System.out.println("===================================================");
                System.out.println("Incorrect input.");
                menuScanner.nextLine();

            } catch (IndexOutOfBoundsException e) {
                System.out.println("===================================================");
                System.out.println("Incorrect position for new book. Please review current collection.");
            }

        } while (userInput > 0);
        
        userScanner.close();
        menuScanner.close();
    } // End of main

    public static void displayMenu() {
        System.out.println("==================================================="
        + "\nMenu\nChoose a number (0 - 14)\n"
        + "1. All books                 8. To be read...\n"
        + "2. By title                  9. Read books\n"
        + "3. By author                 10. Get favorites\n"
        + "4. By price range            11. Add book\n"
        + "5. By release year           12. Add book to position\n"
        + "6. By release year range     13. Remove book by title\n"
        + "7. By page count range       14. Update book\n"
        + "                 0. Exit Program\n");
        System.out.print("Option #: ");
    } // End of displayMenu

    
}
