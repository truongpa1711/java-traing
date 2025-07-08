package OOP.B4_QLDC;

import java.util.List;

public class HoGiaDinh {
    private String soNha;
    private List<Nguoi> danhSachThanhVien= new java.util.ArrayList<>();

    public String getSoNha() {
        return soNha;
    }
    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }
    public List<Nguoi> getDanhSachThanhVien() {
        return danhSachThanhVien;
    }
    public void setDanhSachThanhVien(List<Nguoi> danhSachThanhVien) {
        this.danhSachThanhVien = danhSachThanhVien;
    }

}
