package OOP.B15_QLKetQuaHocTap;

import java.util.List;
import java.util.Scanner;

public class SVTaiChuc extends SinhVien{
    private String noiDaoTao;

    public SVTaiChuc(String maSV, String hoTen, String ngaySinh, String namVaoHoc, Double diemDauVao, List<KetQuaHocTap> ketQuaHocTapList, String noiDaoTao) {
        super(maSV, hoTen, ngaySinh, namVaoHoc, diemDauVao, ketQuaHocTapList);
        this.noiDaoTao = noiDaoTao;
    }
    public SVTaiChuc() {
    }
    public SVTaiChuc(SVTaiChuc other) {
        super(other);
        this.noiDaoTao = other.noiDaoTao;
    }

    public String getNoiDaoTao() {
        return noiDaoTao;
    }
    public void setNoiDaoTao(String noiDaoTao) {
        this.noiDaoTao = noiDaoTao;
    }
    @Override
    public String toString() {
        return "SVTaiChuc{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", namVaoHoc='" + namVaoHoc + '\'' +
                ", diemDauVao=" + diemDauVao +
                ", noiDaoTao='" + noiDaoTao + '\'' +
                ", ketQuaHocTapList=" + ketQuaHocTapList +
                '}';
    }
    @Override
    public void input() {
        super.input();
        // Additional input logic for SVTaiChuc if needed
        System.out.print("Nhap noi dao tao: ");
        Scanner scanner = new Scanner(System.in);
        this.noiDaoTao = scanner.nextLine();
    }
    @Override
    public void output() {
        super.output();
        // Additional output logic for SVTaiChuc if needed
        System.out.println("Noi dao tao: " + noiDaoTao);
    }
}
