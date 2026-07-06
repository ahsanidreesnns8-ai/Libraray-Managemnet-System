class Student extends Person
{
    private String studentID;
    private String enrollmentYear;
    private String department;
    private String email;
    private String phoneNumber;

    public Student(String name, String studentID,
                   String enrollmentYear,
                   String department,
                   String email,
                   String phoneNumber)
    {
        super(name);
        this.studentID = studentID;
        this.enrollmentYear = enrollmentYear;
        this.department = department;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getStudentID()
    {
        return studentID;
    }

    public String getEnrollmentYear()
    {
        return enrollmentYear;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
}