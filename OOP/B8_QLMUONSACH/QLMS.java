package OOP.B8_QLMUONSACH;

import java.util.List;

public class QLMS {
    private List<TheMuon> danhSachMuonSach = new java.util.ArrayList<>();

    public List<TheMuon> getDanhSachMuonSach() {
        return danhSachMuonSach;
    }

    public void setDanhSachMuonSach(List<TheMuon> danhSachMuonSach) {
        this.danhSachMuonSach = danhSachMuonSach;
    }

    public void themPhieuMuon(TheMuon theMuon) {
        danhSachMuonSach.add(theMuon);
    }

    public void xoaPhieuMuonTheoMa(String maPhieu) {
        for (int i = 0; i < danhSachMuonSach.size(); i++) {
            if (danhSachMuonSach.get(i).getMaPhieu().equals(maPhieu)) {
                danhSachMuonSach.remove(i);
                break; // Dừng vòng lặp sau khi xóa
            }
        }
    }

}
