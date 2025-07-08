package OOP.B14_QLTuyenSinh;

public class NormalStudent extends Student{
    private double englishScore;
    private double entryTestScore;

    public double getEnglishScore() {
        return englishScore;
    }
    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }
    public double getEntryTestScore() {
        return entryTestScore;
    }
    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }
    public NormalStudent() {
        super();
        this.englishScore = 0.0;
        this.entryTestScore = 0.0;
    }
    @Override
    public void ShowMyInfor() {
        super.ShowMyInfor();
        System.out.println("English Score: " + englishScore);
        System.out.println("Entry Test Score: " + entryTestScore);
    }
}
