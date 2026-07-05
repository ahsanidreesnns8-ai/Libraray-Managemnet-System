import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class Person
{
    protected String name;

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}


class Librarian extends Person
{
    private String authenticationKey;

    public Librarian(String name, String authenticationKey)
    {
        super(name);
        this.authenticationKey = authenticationKey;
    }
}

class Book
{
    String ISBN;
    String bookID;
    String booktitle;
    String bookauthor;

    public Book(String ISBN, String bookID, String booktitle, String bookauthor)
    {
        this.ISBN = ISBN;
        this.bookID = bookID;
        this.booktitle = booktitle;
        this.bookauthor = bookauthor;
    }

    public void displayBookInfo()
    {


    }


    updateBook()
}


class Student extends Person
{
    private String studID;
    private String enrollmentYear;

    public Student(String name, String studID, String enrollmentYear)
    {
        super(name);
        this.studID = studID;
        this.enrollmentYear = enrollmentYear;
    }



}

class Transaction
{
    Book book;
    Student student;
    String issueDate;
    String returnDate;
    double fine;

    public Transaction(Book book, Student student, String issueDate, String returnDate, double fine)
    {
        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fine = fine;
    }
}

class DatabaseManager
{
    public Connection connect();

    // Book Methods
    public void addBook(Book book);
    public void viewBooks();
    public Book searchBook(String bookID);
    public void updateBook(Book book);
    public void deleteBook(String bookID);

    // Student Methods
    public void addStudent(Student student);
    public void viewStudents();
    public Student searchStudent(String studID);
    public void updateStudent(Student student);
    public void deleteStudent(String studID);

    // Transaction Methods
    public void issueBook(Transaction transaction);
    public void returnBook(String bookID);
    public void viewIssuedBooks();

    // Reports
    public int totalBooks();
    public int totalStudents();
    public int totalIssuedBooks();

    // Utility
    public void closeConnection();
}