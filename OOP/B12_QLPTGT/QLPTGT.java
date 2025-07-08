package OOP.B12_QLPTGT;

import java.util.ArrayList;
import java.util.List;

public class QLPTGT {
    List<PhuongTien> dsPhuongTien= new ArrayList<>();
    public QLPTGT(List<PhuongTien> dsPhuongTien) {
        this.dsPhuongTien = dsPhuongTien;
    }
    public QLPTGT() {
        this.dsPhuongTien = new ArrayList<>();
    }
    public List<PhuongTien> getDsPhuongTien() {
        return dsPhuongTien;
    }

    public void setDsPhuongTien(List<PhuongTien> dsPhuongTien) {
        this.dsPhuongTien = dsPhuongTien;
    }
    public void themPhuongTien(PhuongTien phuongTien) {
        dsPhuongTien.add(phuongTien);
    }
    public boolean xoaPhuongTien(int id) {
        for (PhuongTien pt : dsPhuongTien) {
            if (pt.getID() == id) {
                dsPhuongTien.remove(pt);
                return true; // Trả về true nếu xóa thành công
            }
        }
        return false; // Trả về false nếu không tìm thấy phương tiện với ID đó
    }
    public List<PhuongTien> timPhuonTienTheoHangSanXuat(String hangSanXuat) {
        List<PhuongTien> ketQua = new ArrayList<>();
        for (PhuongTien pt : dsPhuongTien) {
            if (pt.getHangSanXuat().equalsIgnoreCase(hangSanXuat)) {
                ketQua.add(pt);
            }
        }
        return ketQua; // Trả về danh sách phương tiện có cùng hãng sản xuất
    }
    public void inDanhSachPhuongTien() {
        for (PhuongTien pt : dsPhuongTien) {
            System.out.println(pt);
        }
    }
    public List<PhuongTien> timPhuongTienTheoMau(String mauXe) {
        List<PhuongTien> ketQua = new ArrayList<>();
        for (PhuongTien pt : dsPhuongTien) {
            if (pt.getMauXe().equalsIgnoreCase(mauXe)) {
                ketQua.add(pt);
            }
        }
        return ketQua; // Trả về null nếu không tìm thấy
    }



}
