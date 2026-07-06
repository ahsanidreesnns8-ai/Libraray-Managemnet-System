class Librarian extends Person
{
    private String librarianID;
    private String email;
    private String password;

    public Librarian(String name, String librarianID, String email, String password)
    {
        super(name);
        this.librarianID = librarianID;
        this.email = email;
        this.password = password;
    }

    public String getLibrarianID()
    {
        return librarianID;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }
}