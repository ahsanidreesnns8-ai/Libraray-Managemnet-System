class Book
{
    private String ISBN;
    private String bookID;
    private String bookTitle;
    private String bookAuthor;
    private String publisher;
    private int publicationYear;
    private String category;
    private boolean available;

    public Book(String ISBN, String bookID, String bookTitle,
                String bookAuthor, String publisher,
                int publicationYear, String category,
                boolean available)
    {
        this.ISBN = ISBN;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.category = category;
        this.available = available;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public String getBookID()
    {
        return bookID;
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public String getBookAuthor()
    {
        return bookAuthor;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public int getPublicationYear()
    {
        return publicationYear;
    }

    public String getCategory()
    {
        return category;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}
