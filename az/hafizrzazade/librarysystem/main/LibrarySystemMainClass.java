package az.hafizrzazade.librarysystem.main;


import java.util.Scanner;

import az.hafizrzazade.librarysystem.database.Database;
import az.hafizrzazade.librarysystem.model.Book;
import az.hafizrzazade.librarysystem.model.Member;
import az.hafizrzazade.librarysystem.repository.BookRepository;
import az.hafizrzazade.librarysystem.repository.MemberRepository;

public class LibrarySystemMainClass {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Database.connect(); 
        
        Member currentUser = null;

        while (currentUser == null) {
            System.out.println("Welcome to the Library Management System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    currentUser = register(); 
                    break;
                case 2:
                    currentUser = login(); 
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Get all books");
            System.out.println("2. Add book");
            System.out.println("3. Delete book");
            System.out.println("4. Update book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    getAllBooks(); 
                    break;
                case 2:
                    addBook(); 
                    break;
                case 3:
                    deleteBook(); 
                    break;
                case 4:
                    updateBook(); 
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Member register() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Member newUser = new Member(username, password);
        userRepo.registerMember(newUser); 
        System.out.println("Registration successful. You can now log in.");
        return null; 
    }

    private static Member login() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Member user = userRepo.getMemberByUsername(username); 
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            return user; 
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null; 
        }
    }

    private static void getAllBooks() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
    	
        for (Book book : bookRepo.getAllBooks()) {
            System.out.println(book);
        }
    }

    private static void addBook() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        Book newBook = new Book(author, title, false);
        bookRepo.addBook(newBook);
        System.out.println("Book added successfully.");
    }

    private static void deleteBook() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        
        System.out.print("Enter book ID to delete: ");
        String bookId = scanner.nextLine();
        bookRepo.deleteBook(bookId);
        System.out.println("Book deleted successfully.");
    }

    private static void updateBook() {
    	MemberRepository userRepo = new MemberRepository();
        BookRepository bookRepo = new BookRepository();
        
        System.out.print("Enter book ID to update: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter new author: ");
        String newAuthor = scanner.nextLine();
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        Book updatedBook = new Book(bookId, newAuthor, newTitle, false);
        bookRepo.updateBook(updatedBook);
        System.out.println("Book updated successfully.");
    }
}
