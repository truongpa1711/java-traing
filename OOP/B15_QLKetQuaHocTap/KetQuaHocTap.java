package OOP.B15_QLKetQuaHocTap;

import java.util.Scanner;

public class KetQuaHocTap {
    protected String tenHocKy;
    protected Double diemTrungBinh;

    public KetQuaHocTap() {
        // Default constructor
    }
    public KetQuaHocTap(String tenHocKy, Double diemTrungBinh) {
        this.tenHocKy = tenHocKy;
        this.diemTrungBinh = diemTrungBinh;
    }
    public KetQuaHocTap(KetQuaHocTap other) {
        this.tenHocKy = other.tenHocKy;
        this.diemTrungBinh = other.diemTrungBinh;
    }
    public String getTenHocKy() {
        return tenHocKy;
    }
    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }
    public Double getDiemTrungBinh() {
        return diemTrungBinh;
    }
    public void setDiemTrungBinh(Double diemTrungBinh) {
        this.diemTrungBinh = diemTrungBinh;
    }
    @Override
    public String toString() {
        return "KetQuaHocTap{" +
                "tenHocKy='" + tenHocKy + '\'' +
                ", diemTrungBinh=" + diemTrungBinh +
                '}';
    }
    public void input() {
        // Input logic for KetQuaHocTap
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten hoc ky: ");
        this.tenHocKy = scanner.nextLine();
        System.out.print("Nhap diem trung binh: ");
        this.diemTrungBinh = scanner.nextDouble();
    }
    public void output() {
        // Display logic for KetQuaHocTap
        System.out.println("Ten hoc ky: " + tenHocKy);
        System.out.println("Diem trung binh: " + diemTrungBinh);
    }

    public Double getDiemTrungBinhTheoHocKy(String tenHocKy) {
        if (this.tenHocKy.equalsIgnoreCase(tenHocKy)) {
            return this.diemTrungBinh;
        }
        return null;
    }
}
