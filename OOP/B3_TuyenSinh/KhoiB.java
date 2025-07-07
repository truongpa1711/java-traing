package OOP.B3_TuyenSinh;

public class KhoiB extends ThiSinh{
    private double toan;
    private double hoa;
    private double sinh;
    public KhoiB(String hoTen, String diaChi, String mucUuTien, double toan, double hoa, double sinh) {
        super(hoTen, diaChi, mucUuTien);
        this.toan = toan;
        this.hoa = hoa;
        this.sinh = sinh;
    }
    public double getToan() {
        return toan;
    }
    public void setToan(double toan) {
        this.toan = toan;
    }
    public double getHoa() {
        return hoa;
    }
    public void setHoa(double hoa) {
        this.hoa = hoa;
    }
    public double getSinh() {
        return sinh;
    }
    public void setSinh(double sinh) {
        this.sinh = sinh;
    }
}
