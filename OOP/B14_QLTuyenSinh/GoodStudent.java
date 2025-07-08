package OOP.B14_QLTuyenSinh;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;

    public double getGpa() {
        return gpa;
    }
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public String getBestRewardName() {
        return bestRewardName;
    }
    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    public GoodStudent(String fullName, String dob, String sex, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, dob, sex, phoneNumber, universityName, gradeLevel);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void ShowMyInfor() {
        super.ShowMyInfor();
        System.out.println("GPA: " + gpa);
        System.out.println("Best Reward Name: " + bestRewardName);
    }

}
