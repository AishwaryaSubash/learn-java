import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Book implements Serializable {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    private boolean availability;
    private String genre;

    public Book(String ISBN, String title, String author, double price, boolean availability, String genre) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
        this.genre = genre;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return availability;
    }

    public String getGenre() {
        return genre;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book\n" +
                "ISBN: " + ISBN + "\n" +
                "Title: " + title + "\n" +
                "Author: " + author + "\n" +
                "Price: " + price + "\n" +
                "Availability: " + availability + "\n" +
                "Genre: " + genre + "\n";
    }
}

class Library implements Serializable {
    private List<Book> books;
    private String libraryName;
    private String address;

    public Library(String libraryName, String address) {
        this.books = new ArrayList<>();
        this.libraryName = libraryName;
        this.address = address;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String ISBN) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
        }
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> searchByGenre(String genre) {
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equals(genre)) {
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }

    public void displayAvailableBooks() {
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}

class Member {
    private String memberID;
    private String name;
    private List<Book> borrowedBooks;

    public Member(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) throws NotEnoughBooksException {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailability(false);
        } else {
            throw new NotEnoughBooksException("Not enough copies of the book available for borrowing.");
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailability(true);
    }

    public void displayBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book);
        }
    }
}

class SerializationHandler {
    public void serializeLibrary(Library library, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Library deserializeLibrary(String fileName) {
        Library library = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            library = (Library) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return library;
    }
}

class BookNotFoundException extends Exception {
    public BookNotFoundException(String message) {
        super(message);
    }
}

class NotEnoughBooksException extends Exception {
    public NotEnoughBooksException(String message) {
        super(message);
    }
}

public class LMS {
    public static void main(String[] args) {
        Library library = new Library("My Library", "123 Main St");
        Book book1 = new Book("123456", "Java Programming", "John Doe", 29.99, true, "Programming");
        Book book2 = new Book("789012", "Python Basics", "Jane Smith", 19.99, true, "Programming");
        library.addBook(book1);
        library.addBook(book2);

        System.out.println("Available books in the library:");
        library.displayAvailableBooks();
        System.out.println();

        Member member = new Member("001", "Alice");
        try {
            member.borrowBook(book1);
            member.borrowBook(book2);
        } catch (NotEnoughBooksException e) {
            e.printStackTrace();
        }

        System.out.println("Books borrowed by Alice:");
        member.displayBorrowedBooks();
        System.out.println();

        member.returnBook(book1);

        System.out.println("Available books in the library after returning one book:");
        library.displayAvailableBooks();
        System.out.println();

        SerializationHandler serializationHandler = new SerializationHandler();
        serializationHandler.serializeLibrary(library, "library.ser");
        System.out.println("Library serialized successfully.");

        Library deserializedLibrary = serializationHandler.deserializeLibrary("library.ser");
        if (deserializedLibrary != null) {
            System.out.println("Available books in the deserialized library:");
            deserializedLibrary.displayAvailableBooks();
        } else {
            System.out.println("Error: Unable to deserialize the library.");
        }
    }
}
