import java.sql.*;

class DatabaseManager
{
    private Connection conn;

    public Connection connect()
    {
        try
        {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/librarydb",
                    "root",
                    "ahsanidrees1044");

            System.out.println("Connected");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    // Book
    public void addBook(Book book)
    {
        try
        {
            String query = "INSERT INTO books (ISBN, bookID, bookTitle, bookAuthor, publisher, publicationYear, category, available) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, book.getISBN());
            ps.setString(2, book.getBookID());
            ps.setString(3, book.getBookTitle());
            ps.setString(4, book.getBookAuthor());
            ps.setString(5, book.getPublisher());
            ps.setInt(6, book.getPublicationYear());
            ps.setString(7, book.getCategory());
            ps.setBoolean(8, book.isAvailable());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                System.out.println("Book added successfully.");
            }
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void viewBooks()
    {
        try
        {
            String query = "SELECT * FROM books";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println("--------------------------------");
                System.out.println("ISBN : " + rs.getString("ISBN"));
                System.out.println("Book ID : " + rs.getString("bookID"));
                System.out.println("Title : " + rs.getString("bookTitle"));
                System.out.println("Author : " + rs.getString("bookAuthor"));
                System.out.println("Publisher : " + rs.getString("publisher"));
                System.out.println("Year : " + rs.getInt("publicationYear"));
                System.out.println("Category : " + rs.getString("category"));
                System.out.println("Available : " + rs.getBoolean("available"));
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public Book searchBook(String bookID)
    {
        try
        {
            String query = "SELECT * FROM books WHERE bookID = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, bookID);
            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Book book = new Book(
                        rs.getString("ISBN"),
                        rs.getString("bookID"),
                        rs.getString("bookTitle"),
                        rs.getString("bookAuthor"),
                        rs.getString("publisher"),
                        rs.getInt("publicationYear"),
                        rs.getString("category"),
                        rs.getBoolean("available")
                );
                rs.close();
                ps.close();
                return book;
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void updateBook(Book book)
    {
        try
        {
            String query = "UPDATE books SET bookTitle=?, bookAuthor=?, publisher=?, publicationYear=?, category=?, available=? WHERE bookID=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, book.getBookTitle());
            ps.setString(2, book.getBookAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getPublicationYear());
            ps.setString(5, book.getCategory());
            ps.setBoolean(6, book.isAvailable());
            ps.setString(7, book.getBookID());

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Book Updated Successfully.");
            }
            else
            {
                System.out.println("Book Not Found.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void deleteBook(String bookID)
    {
        try
        {
            String query = "DELETE FROM books WHERE bookID=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, bookID);

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Book Deleted Successfully.");
            }
            else
            {
                System.out.println("Book Not Found.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    // Student

    public void addStudent(Student student)
    {
        try
        {
            String query = "INSERT INTO students (studentID, name, enrollmentYear, department, email, phoneNumber) VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getStudentID());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEnrollmentYear());
            ps.setString(4, student.getDepartment());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getPhoneNumber());

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Student Registered Successfully.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void viewStudents()
    {
        try
        {
            String query = "SELECT * FROM students";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println("--------------------------------");
                System.out.println("Student ID : " + rs.getString("studentID"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Enrollment Year : " + rs.getString("enrollmentYear"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Email : " + rs.getString("email"));
                System.out.println("Phone : " + rs.getString("phoneNumber"));
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public Student searchStudent(String studentID)
    {
        try
        {
            String query = "SELECT * FROM students WHERE studentID = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, studentID);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getString("studentID"),
                        rs.getString("enrollmentYear"),
                        rs.getString("department"),
                        rs.getString("email"),
                        rs.getString("phoneNumber")
                );

                rs.close();
                ps.close();

                return student;
            }

            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return null;
    }


    public void updateStudent(Student student)
    {
        try
        {
            String query = "UPDATE students SET name=?, enrollmentYear=?, department=?, email=?, phoneNumber=? WHERE studentID=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEnrollmentYear());
            ps.setString(3, student.getDepartment());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhoneNumber());
            ps.setString(6, student.getStudentID());

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Student Updated Successfully.");
            }
            else
            {
                System.out.println("Student Not Found.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void deleteStudent(String studentID)
    {
        try
        {
            String query = "DELETE FROM students WHERE studentID=?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, studentID);

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Student Deleted Successfully.");
            }
            else
            {
                System.out.println("Student Not Found.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    // Transactions
    public void issueBook(Transaction transaction)
    {
        try
        {
            String query = "INSERT INTO transactions(transactionID, bookID, studentID, issueDate, dueDate, returnDate, fine) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, transaction.getTransactionID());
            ps.setString(2, transaction.getBook().getBookID());
            ps.setString(3, transaction.getStudent().getStudentID());
            ps.setString(4, transaction.getIssueDate());
            ps.setString(5, transaction.getDueDate());
            ps.setString(6, transaction.getReturnDate());
            ps.setDouble(7, transaction.getFine());

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                PreparedStatement update = conn.prepareStatement(
                        "UPDATE books SET available = FALSE WHERE bookID = ?");

                update.setString(1, transaction.getBook().getBookID());
                update.executeUpdate();
                update.close();

                System.out.println("Book Issued Successfully.");
            }

            ps.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void returnBook(String transactionID)
    {
        try
        {
            String bookID = null;

            PreparedStatement find = conn.prepareStatement(
                    "SELECT bookID FROM transactions WHERE transactionID = ?");

            find.setString(1, transactionID);

            ResultSet rs = find.executeQuery();

            if(rs.next())
            {
                bookID = rs.getString("bookID");
            }

            rs.close();
            find.close();

            PreparedStatement updateTransaction = conn.prepareStatement(
                    "UPDATE transactions SET returnDate = CURDATE() WHERE transactionID = ?");

            updateTransaction.setString(1, transactionID);
            updateTransaction.executeUpdate();
            updateTransaction.close();

            if(bookID != null)
            {
                PreparedStatement updateBook = conn.prepareStatement(
                        "UPDATE books SET available = TRUE WHERE bookID = ?");

                updateBook.setString(1, bookID);
                updateBook.executeUpdate();
                updateBook.close();
            }

            System.out.println("Book Returned Successfully.");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    public void viewIssuedBooks()
    {
        try
        {
            String query = "SELECT * FROM transactions";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                System.out.println("--------------------------------");
                System.out.println("Transaction ID : " + rs.getString("transactionID"));
                System.out.println("Book ID : " + rs.getString("bookID"));
                System.out.println("Student ID : " + rs.getString("studentID"));
                System.out.println("Issue Date : " + rs.getDate("issueDate"));
                System.out.println("Due Date : " + rs.getDate("dueDate"));
                System.out.println("Return Date : " + rs.getDate("returnDate"));
                System.out.println("Fine : " + rs.getDouble("fine"));
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    // Reports
    public int totalBooks()
    {
        try
        {
            String query = "SELECT COUNT(*) FROM books";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next())
            {
                return rs.getInt(1);
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return 0;
    }


    public int totalStudents()
    {
        try
        {
            String query = "SELECT COUNT(*) FROM students";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next())
            {
                return rs.getInt(1);
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return 0;
    }


    public int totalIssuedBooks()
    {
        try
        {
            String query = "SELECT COUNT(*) FROM transactions WHERE returnDate IS NULL";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if(rs.next())
            {
                return rs.getInt(1);
            }

            rs.close();
            st.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

        return 0;
    }


    public void closeConnection()
    {
        try
        {
            if(conn != null)
            {
                conn.close();
                System.out.println("Database Connection Closed.");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}