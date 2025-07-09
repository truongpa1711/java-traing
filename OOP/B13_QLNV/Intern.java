package OOP.B13_QLNV;

import java.util.List;

public class Intern extends Employee{
    private String Majors;
    private String Semester;
    private String University_name;

    public Intern(String id,String fullName, String birthDay, String phone, String email, List<Certificate>certificates, String majors, String semester, String university_name) {
        super(id,fullName, birthDay, phone, email, Employee_type.Intern, certificates);
        this.Majors = majors;
        this.Semester = semester;
        this.University_name = university_name;
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public void ShowInfo() {
        System.out.println(
                "Intern{" +
                        "\n    ID='" + getID() + '\'' +
                        ",\n    fullName='" + getFullName() + '\'' +
                        ",\n    birthDay='" + getBirthDay() + '\'' +
                        ",\n    phone='" + getPhone() + '\'' +
                        ",\n    email='" + getEmail() + '\'' +
                        ",\n    employeeType=" + getEmployeeType() +
                        ",\n    Certificates=" + certificates +
                        ",\n    Majors='" + Majors + '\'' +
                        ",\n    Semester='" + Semester + '\'' +
                        ",\n    University_name='" + University_name + '\'' +
                        "\n}"
        );
    }
}
