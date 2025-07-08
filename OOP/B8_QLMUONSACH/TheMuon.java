package OOP.B8_QLMUONSACH;

public class TheMuon {
    private String maPhieu;
    private String ngayMuon;
    private String hanTra;
    private int soHieuSach;
    private SinhVien sinhVien;

    public String getMaPhieu() {
        return maPhieu;
    }
    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }
    public String getNgayMuon() {
        return ngayMuon;
    }
    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }
    public String getHanTra() {
        return hanTra;
    }
    public void setHanTra(String hanTra) {
        this.hanTra = hanTra;
    }
    public int getSoHieuSach() {
        return soHieuSach;
    }
    public void setSoHieuSach(int soHieuSach) {
        this.soHieuSach = soHieuSach;
    }
    public SinhVien getSinhVien() {
        return sinhVien;
    }
    public void setSinhVien(SinhVien sinhVien) {
        this.sinhVien = sinhVien;
    }
    public TheMuon(String maPhieu, String ngayMuon, String hanTra, int soHieuSach, SinhVien sinhVien) {
        this.maPhieu = maPhieu;
        this.ngayMuon = ngayMuon;
        this.hanTra = hanTra;
        this.soHieuSach = soHieuSach;
        this.sinhVien = sinhVien;
    }
    @Override
    public String toString() {
        return "TheMuon{" +
                "maPhieu='" + maPhieu + '\'' +
                ", ngayMuon='" + ngayMuon + '\'' +
                ", hanTra='" + hanTra + '\'' +
                ", soHieuSach=" + soHieuSach +
                ", sinhVien=" + sinhVien.getHoTen() +
                '}';
    }
}
