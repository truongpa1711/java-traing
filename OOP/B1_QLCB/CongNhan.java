package OOP.B1_QLCB;

public class CongNhan extends CanBo{
    private int bac ;
    public CongNhan(String hoten, int tuoi, gioitinh gt, String diachi, int bac) {
        super(hoten, tuoi, gt, diachi);
        this.bac = bac;
    }
    public int getBac() {
        return bac;
    }
    public void setBac(int bac) {
        this.bac = bac;
    }
}
