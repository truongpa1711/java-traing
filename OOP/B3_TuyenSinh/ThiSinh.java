package OOP.B3_TuyenSinh;

public class ThiSinh {
    public static int count = 0;
    protected String SBD;
    protected String hoTen;
    protected String diaChi;
    protected String mucUuTien;

    public ThiSinh(String hoTen, String diaChi, String mucUuTien) {
        this.SBD = "TS" + ++count;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }
    public String getSBD() {
        return SBD;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getMucUuTien() {
        return mucUuTien;
    }
    public void setMucUuTien(String mucUuTien) {
        this.mucUuTien = mucUuTien;
    }

}
