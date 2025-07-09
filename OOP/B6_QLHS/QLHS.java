package OOP.B6_QLHS;

import java.util.List;

public class QLHS {
    List<HocSinh> danhSachHocSinh = new java.util.ArrayList<>();
    public List<HocSinh> getDanhSachHocSinh() {
        return danhSachHocSinh;
    }
    public void setDanhSachHocSinh(List<HocSinh> danhSachHocSinh) {
        this.danhSachHocSinh = danhSachHocSinh;
    }
    public void themHocSinh(HocSinh hocSinh) {
        danhSachHocSinh.add(hocSinh);
    }
    public List<HocSinh> timKiemHocSinhTren20Tuoi() {
        List<HocSinh> ketQua = new java.util.ArrayList<>();
        for (HocSinh hs : danhSachHocSinh) {
            if (hs.getTuoi() > 20) {
                ketQua.add(hs);
            }
        }
        return ketQua;
    }
    public int demHocSinhTheoQueQuan() {
        List<HocSinh> ketQua = new java.util.ArrayList<>();
        for (HocSinh hs : danhSachHocSinh) {
            if (hs.getQueQuan().equalsIgnoreCase("DN")&& hs.getTuoi() == 23) {
                ketQua.add(hs);
            }
        }
        return ketQua.size();
    }
}
