//import java.util.ArrayList;
//import java.util.Scanner;
//
//class LMS{
//    private String email;
//    private String Password;
//    String Full_Name;
//    String Registration_No;
//    String CNIC;
//    String Gender;
//    String Father_Name;
//    String Father_CNIC;
//    String Email_Stud;
//    String Campus;
//    String District;
//    String Province;
//    String Session;
//    String DOB;
//    String Contact_1;
//    String Contact_2;
//    String Admission_Category;
//    String Hostel;
//    int Room;
//    String Allotment_date;
//    String State;
//
//    public String getEmail() {
//        return email;
//    }
//    public String getPassword() {
//        return Password;
//    }
//    public void setLoginDetails(String email, String password)
//    {
//        this.email = email;
//        this.Password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "LMS\n" +
//                "Full_Name ='" + Full_Name + '\'' +
//                ", \nRegistration_No ='" + Registration_No + '\'' +
//                ", \nCNIC =" + CNIC +
//                ", \nGender='" + Gender + '\'' +
//                ", \nFather_Name='" + Father_Name + '\'' +
//                ", \nFather_CNIC='" + Father_CNIC + '\'' +
//                ", \nEmail_Stud='" + Email_Stud + '\'' +
//                ", \nCampus='" + Campus + '\'' +
//                ", \nDistrict='" + District + '\'' +
//                ", \nProvince='" + Province + '\'' +
//                ", \nSession='" + Session + '\'' +
//                ", \nDOB='" + DOB + '\'' +
//                ", \nContact_1=" + Contact_1 +
//                ", \nContact_2=" + Contact_2 +
//                ", \nAdmission_Category='" + Admission_Category + '\'' +
//                ", \nHostel='" + Hostel + '\'' +
//                ", \nRoom=" + Room +
//                ", \nAllotment_date='" + Allotment_date + '\'' +
//                ", \nState='" + State + '\'';
//    }
//}
// public class LMS_Project{
//     public static void main(String[] args) {
//         LMS Stud_1 = new LMS();
//
//         Stud_1.Full_Name = "M. Ahsan Idrees";
//         Stud_1.Registration_No = "2025-CYS-112";
//         Stud_1.CNIC = "3550103807965";
//         Stud_1.Gender = "Male";
//         Stud_1.Father_Name = "Idrees Ahmad";
//         Stud_1.Father_CNIC = "35402-9757470-1";
//         Stud_1.Email_Stud = "2025CYS112@uet.student.edu.pk";
//         Stud_1.Campus = "UET Lahore";
//         Stud_1.District = "Nankana Sahib";
//         Stud_1.Province = "Punjab";
//         Stud_1.Session = "2025-Fall";
//         Stud_1.DOB = "11-09-2006";
//         Stud_1.Contact_1 = "+923224398646";
//         Stud_1.Contact_2 = "+923277236365";
//         Stud_1.Admission_Category = "Regular";
//         Stud_1.Hostel = "Yes";
//         Stud_1.Room = 87;
//         Stud_1.Allotment_date = "19-01-2025";
//         Stud_1.State = "Active";
//         Stud_1.setLoginDetails("2025CYS112@uet.student.edu.pk","t-oZ6Urm");
//         Scanner inp = new Scanner(System.in);
//         int chance=0;
//         while (true){
//             System.out.println("Enter Your Emial: ");
//             String Stud1_email = inp.nextLine();
//             System.out.println("Enter Your Password: ");
//             String Stud1_password = inp.nextLine();
//             chance++;
//             if (chance<=3) {
//                 if ((Stud1_email.equals(Stud_1.getEmail())) &&  (Stud1_password.equals(Stud_1.getPassword())))
//                 {
//                     System.out.println(Stud_1);
//                     break;
//                 }
//                 else{
//                     System.out.println("Incorrect Details...");
//                     continue;
//                 }
//             } else if (chance>3)
//             {
//                 System.out.println("You entered wrong details for "+chance+" times.So,Your account has been locked");
//                 break;
//             }
//         }
//     }
//}