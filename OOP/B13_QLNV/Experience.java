package OOP.B13_QLNV;

import java.util.List;

public class Experience extends Employee{
    private int ExpInYear;
    private String ProSkill;
    public Experience(String id,String fullName, String birthDay, String phone, String email, List<Certificate> certificates, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, Employee_type.Experience, certificates);
        this.ExpInYear = expInYear;
        this.ProSkill = proSkill;
    }
    public int getExpInYear() {
        return ExpInYear;
    }
    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }
    public String getProSkill() {
        return ProSkill;
    }
    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public void ShowInfo() {
        System.out.println(
                "Experience{" +
                        "\n    ID='" + getID() + '\'' +
                        ",\n    fullName='" + getFullName() + '\'' +
                        ",\n    birthDay='" + getBirthDay() + '\'' +
                        ",\n    phone='" + getPhone() + '\'' +
                        ",\n    email='" + getEmail() + '\'' +
                        ",\n    employeeType=" + getEmployeeType() +
                        ",\n    Certificates=" + certificates +
                        ",\n    ExpInYear=" + ExpInYear +
                        ",\n    ProSkill='" + ProSkill + '\'' +
                        "\n}"
        );
    }
}
