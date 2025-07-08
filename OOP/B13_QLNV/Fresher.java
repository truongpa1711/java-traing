package OOP.B13_QLNV;

import java.util.List;

public class Fresher extends Employee{
    private String Graduation_date;
    private String Graduation_rank;
    private String Education;

    public Fresher(String id,String fullName, String birthDay, String phone, String email, List<Certificate> certificates, String graduation_date, String graduation_rank, String education) {
        super(id, fullName, birthDay, phone, email, Employee_type.Fresher, certificates);
        this.Graduation_date = graduation_date;
        this.Graduation_rank = graduation_rank;
        this.Education = education;
    }
    public String getGraduation_date() {
        return Graduation_date;
    }
    public void setGraduation_date(String graduation_date) {
        Graduation_date = graduation_date;
    }
    public String getGraduation_rank() {
        return Graduation_rank;
    }
    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }
    public String getEducation() {
        return Education;
    }
    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public void ShowInfo() {
        System.out.println(
                "Fresher{" +
                        "\n    ID='" + getID() + '\'' +
                        ",\n    fullName='" + getFullName() + '\'' +
                        ",\n    birthDay='" + getBirthDay() + '\'' +
                        ",\n    phone='" + getPhone() + '\'' +
                        ",\n    email='" + getEmail() + '\'' +
                        ",\n    employeeType=" + getEmployeeType() +
                        ",\n    Certificates=" + certificates +
                        ",\n    Graduation_date='" + Graduation_date + '\'' +
                        ",\n    Graduation_rank='" + Graduation_rank + '\'' +
                        ",\n    Education='" + Education + '\'' +
                        "\n}"
        );
    }
}
