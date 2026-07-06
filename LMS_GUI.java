import javax.swing.*;
import java.awt.*;

class LibraryGUI
{
    private JFrame frame;
    private DatabaseManager db;

    public LibraryGUI()
    {
        db = new DatabaseManager();
        db.connect();

        frame = new JFrame("Library Management System");
        frame.setSize(550, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("📚 Library Management System", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.BOLD, 26));
        title.setForeground(new Color(0, 51, 102));
        title.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(0, 102, 204)));

        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1, 12, 12));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        panel.setBackground(new Color(230, 240, 250));

        String[] options =
                {
                        "➕ Add Book",
                        "📖 View Books",
                        "🔍 Search Book",
                        "👤 Register Student",
                        "👥 View Students",
                        "📕 Issue Book",
                        "📗 Return Book",
                        "📂 View Issued Books",
                        "📊 Reports",
                        "❌ Exit"
                };

        for (String option : options)
        {
            JButton button = new JButton(option);

            button.setFont(new Font("Segoe UI", Font.BOLD, 16));
            button.setBackground(new Color(0, 153, 153));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));

            button.addActionListener(e -> performAction(option));

            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void performAction(String option)
    {
        switch(option)
        {
            case "➕ Add Book":
                addBook();
                break;

            case "📖 View Books":
                db.viewBooks();
                break;

            case "🔍 Search Book":
                searchBook();
                break;

            case "👤 Register Student":
                registerStudent();
                break;

            case "👥 View Students":
                db.viewStudents();
                break;

            case "📕 Issue Book":
                issueBook();
                break;

            case "📗 Return Book":
                returnBook();
                break;

            case "📂 View Issued Books":
                db.viewIssuedBooks();
                break;

            case "📊 Reports":
                showReports();
                break;

            case "❌ Exit":
                db.closeConnection();
                System.exit(0);
        }
    }

    private void addBook()
    {
        String isbn = JOptionPane.showInputDialog("Enter ISBN:");
        String id = JOptionPane.showInputDialog("Enter Book ID:");
        String title = JOptionPane.showInputDialog("Enter Book Title:");
        String author = JOptionPane.showInputDialog("Enter Author:");
        String publisher = JOptionPane.showInputDialog("Enter Publisher:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Publication Year:"));
        String category = JOptionPane.showInputDialog("Enter Category:");

        Book book = new Book(isbn, id, title, author, publisher, year, category, true);

        db.addBook(book);
    }

    private void searchBook()
    {
        String id = JOptionPane.showInputDialog("Enter Book ID:");

        Book book = db.searchBook(id);

        if(book == null)
        {
            JOptionPane.showMessageDialog(null, "Book Not Found");
        }
        else
        {
            JOptionPane.showMessageDialog(null,
                    "Title : " + book.getBookTitle()
                            + "\nAuthor : " + book.getBookAuthor()
                            + "\nISBN : " + book.getISBN());
        }
    }

    private void registerStudent()
    {
        String name = JOptionPane.showInputDialog("Student Name:");
        String id = JOptionPane.showInputDialog("Student ID:");
        String year = JOptionPane.showInputDialog("Enrollment Year:");
        String department = JOptionPane.showInputDialog("Department:");
        String email = JOptionPane.showInputDialog("Email:");
        String phone = JOptionPane.showInputDialog("Phone Number:");

        Student student = new Student(name, id, year, department, email, phone);

        db.addStudent(student);
    }

    private void issueBook()
    {
        JOptionPane.showMessageDialog(null, "Issue Book Feature");
    }

    private void returnBook()
    {
        String transactionID = JOptionPane.showInputDialog("Enter Transaction ID:");

        db.returnBook(transactionID);
    }

    private void showReports()
    {
        int books = db.totalBooks();
        int students = db.totalStudents();
        int issued = db.totalIssuedBooks();

        JOptionPane.showMessageDialog(null,
                "Total Books : " + books
                        + "\nTotal Students : " + students
                        + "\nIssued Books : " + issued);
    }
}