package OOP.B7_QLGV;

import java.util.ArrayList;

public class QLGV {
    private ArrayList<CBGV> danhSachCBGV;

    public QLGV() {
        this.danhSachCBGV = new ArrayList<>();
    }
    public ArrayList<CBGV> getDanhSachCBGV() {
        return danhSachCBGV;
    }
    public void setDanhSachCBGV(ArrayList<CBGV> danhSachCBGV) {
        this.danhSachCBGV = danhSachCBGV;
    }
    public void themCBGV(CBGV cbgv) {
        danhSachCBGV.add(cbgv);
    }

    public void xoaCBGVTheoMa(String maCBGV) {
        for (int i = 0; i < danhSachCBGV.size(); i++) {
            if (danhSachCBGV.get(i).getGv().getMaSo().equals(String.valueOf(maCBGV))) {
                danhSachCBGV.remove(i);
                break; // Dừng vòng lặp sau khi xóa
            }
        }
    }
}
