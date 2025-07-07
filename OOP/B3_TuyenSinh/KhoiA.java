package OOP.B3_TuyenSinh;

public class KhoiA extends ThiSinh{
    private double toan;
    private double ly;
    private double hoa;

    public KhoiA(String hoTen, String diaChi, String mucUuTien, double toan, double ly, double hoa) {
        super(hoTen, diaChi, mucUuTien);
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }
    public double getToan() {
        return toan;
    }
    public void setToan(double toan) {
        this.toan = toan;
    }
    public double getLy() {
        return ly;
    }
    public void setLy(double ly) {
        this.ly = ly;
    }
    public double getHoa() {
        return hoa;
    }
    public void setHoa(double hoa) {
        this.hoa = hoa;
    }

}
