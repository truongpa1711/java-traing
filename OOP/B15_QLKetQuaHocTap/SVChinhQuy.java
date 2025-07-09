package OOP.B15_QLKetQuaHocTap;

import java.util.List;

public class SVChinhQuy extends SinhVien{

    public SVChinhQuy() {
        // Default constructor
    }
    public SVChinhQuy(SVChinhQuy other) {
        super(other);
    }
    public SVChinhQuy(String maSV, String hoTen, String ngaySinh, String namVaoHoc, Double diemDauVao, List<KetQuaHocTap> ketQuaHocTapList) {
        super(maSV, hoTen, ngaySinh, namVaoHoc, diemDauVao, ketQuaHocTapList);
    }

    @Override
    public String toString() {
        return "SVChinhQuy{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", namVaoHoc='" + namVaoHoc + '\'' +
                ", diemDauVao=" + diemDauVao +
                ", ketQuaHocTapList=" + ketQuaHocTapList +
                '}';
    }
    @Override
    public void input() {
        super.input();
        // Additional input logic for SVChinhQuy if needed
    }
    @Override
    public void output() {
        super.output();
        // Additional output logic for SVChinhQuy if needed
    }
}
