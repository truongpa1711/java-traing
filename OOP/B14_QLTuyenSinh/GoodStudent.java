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
    public GoodStudent(){
        super();
        this.gpa = 0.0;
        this.bestRewardName = "";
    }

    @Override
    public void ShowMyInfor() {
        super.ShowMyInfor();
        System.out.println("GPA: " + gpa);
        System.out.println("Best Reward Name: " + bestRewardName);
    }

}
