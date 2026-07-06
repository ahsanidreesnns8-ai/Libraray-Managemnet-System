class Transaction
{
    private String transactionID;
    private Book book;
    private Student student;
    private String issueDate;
    private String dueDate;
    private String returnDate;
    private double fine;

    public Transaction(String transactionID,
                       Book book,
                       Student student,
                       String issueDate,
                       String dueDate,
                       String returnDate,
                       double fine)
    {
        this.transactionID = transactionID;
        this.book = book;
        this.student = student;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fine = fine;
    }

    public String getTransactionID()
    {
        return transactionID;
    }

    public Book getBook()
    {
        return book;
    }

    public Student getStudent()
    {
        return student;
    }

    public String getIssueDate()
    {
        return issueDate;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    public String getReturnDate()
    {
        return returnDate;
    }

    public double getFine()
    {
        return fine;
    }

    public void setFine(double fine)
    {
        this.fine = fine;
    }
}