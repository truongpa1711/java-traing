package OOP.B9_QLTienDien;

public class BienLai {
    private khachHang khachHang;
    private int chiSoCu;
    private int chiSoMoi;
    private float soTien;

    public khachHang getKhachHang() {
        return khachHang;
    }
    public void setKhachHang(khachHang khachHang) {
        this.khachHang = khachHang;
    }
    public int getChiSoCu() {
        return chiSoCu;
    }
    public void setChiSoCu(int chiSoCu) {
        this.chiSoCu = chiSoCu;
    }

    public int getChiSoMoi() {
        return chiSoMoi;
    }
    public void setChiSoMoi(int chiSoMoi) {
        this.chiSoMoi = chiSoMoi;
    }
    public float getSoTien() {
        return soTien;
    }
    public void setSoTien() {
        this.soTien = (chiSoMoi - chiSoCu) * 5;
    }
    @Override
    public String toString() {
        return "BienLai{" +
                "khachHang=" + khachHang.getHoTen() +
                ", soNha='" + khachHang.getSoNha() + '\'' +
                ", maSoCongTo='" + khachHang.getMaSoCongTo() + '\'' +
                ", chiSoCu=" + chiSoCu +
                ", chiSoMoi=" + chiSoMoi +
                ", soTien=" + soTien +
                '}';
    }
}
