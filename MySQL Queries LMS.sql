CREATE DATABASE librarydb;
USE librarydb;

CREATE TABLE books
(
   ISBN VARCHAR(20) PRIMARY KEY,
   bookID VARCHAR(20) UNIQUE NOT NULL,
   bookTitle VARCHAR(150) NOT NULL,
   bookAuthor VARCHAR(50) NOT NULL,
   publisher VARCHAR(50) NOT NULL,
   publicationYear INT NOT NULL,
   category VARCHAR(50) NOT NULL,
   available BOOLEAN DEFAULT TRUE
);

CREATE TABLE students
(
  studentID VARCHAR(50) PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  enrollmentYear VARCHAR(10) NOT NULL,
  department VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL,
  phoneNumber VARCHAR(50) NOT NULL
);

CREATE TABLE librarians
(
    librarianID VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE transactions 
(
    transactionID VARCHAR(20) PRIMARY KEY,
    bookID VARCHAR(20) NOT NULL,
    studentID VARCHAR(20) NOT NULL,
    issueDate DATE NOT NULL,
    dueDate DATE NOT NULL,
    returnDate DATE,
    fine DECIMAL(8,2) DEFAULT 0.00,
    FOREIGN KEY (bookID) REFERENCES books(bookID),
    FOREIGN KEY (studentID) REFERENCES students(studentID)
);


SELECT * FROM books;
SELECT * FROM transactions;
SELECT * FROM students;
SELECT * FROM librarians;