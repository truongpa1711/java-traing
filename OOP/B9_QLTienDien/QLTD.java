package OOP.B9_QLTienDien;

import java.util.ArrayList;

public class QLTD {
    ArrayList<BienLai> danhSachBienLai = new ArrayList<>();
    public ArrayList<BienLai> getDanhSachBienLai() {
        return danhSachBienLai;
    }
    public void setDanhSachBienLai(ArrayList<BienLai> danhSachBienLai) {
        this.danhSachBienLai = danhSachBienLai;
    }
    public void themBienLai(BienLai bienLai) {
        danhSachBienLai.add(bienLai);
    }
    public void xoaBienLaiTheoMa(String maSoCongTo) {
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            if (danhSachBienLai.get(i).getKhachHang().getMaSoCongTo().equals(maSoCongTo)) {
                danhSachBienLai.remove(i);
                break; // Dừng vòng lặp sau khi xóa
            }
        }
    }
    public void suaKhachHangTheoMa(String maSoCongTo, khachHang khachHang) {
        for (int i = 0; i < danhSachBienLai.size(); i++) {
            if (danhSachBienLai.get(i).getKhachHang().getMaSoCongTo().equals(maSoCongTo)) {
                danhSachBienLai.get(i).setKhachHang(khachHang);
                break; // Dừng vòng lặp sau khi sửa
            }
        }

    }
}
