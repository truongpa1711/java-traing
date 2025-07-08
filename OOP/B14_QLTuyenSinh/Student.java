package OOP.B14_QLTuyenSinh;

public abstract class Student {
    private String fullName;
    private String doB;
    private String sex;
    private String phoneNumber;
    private String universityName;
    private String gradeLevel;

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getDoB() {
        return doB;
    }
    public void setDoB(String doB) {
        this.doB = doB;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getUniversityName() {
        return universityName;
    }
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    public String getGradeLevel() {
        return gradeLevel;
    }
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Student(String fullName, String doB, String sex, String phoneNumber, String universityName, String gradeLevel) {
        this.fullName = fullName;
        this.doB = doB;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

    public void ShowMyInfor(){
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + doB);
        System.out.println("Sex: "+sex);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("University Name: " + universityName);
        System.out.println("Grade Level: " + gradeLevel);
    }
}
