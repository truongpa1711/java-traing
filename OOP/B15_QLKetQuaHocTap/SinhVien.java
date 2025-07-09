package OOP.B15_QLKetQuaHocTap;

import java.util.List;
import java.util.Scanner;

public abstract class SinhVien {
    protected String maSV;
    protected String hoTen;
    protected String ngaySinh;
    protected String namVaoHoc;
    protected Double diemDauVao;
    protected List<KetQuaHocTap> ketQuaHocTapList;

    public SinhVien() {
        // Default constructor
    }
    public SinhVien(String maSV, String hoTen, String ngaySinh, String namVaoHoc, Double diemDauVao, List<KetQuaHocTap> ketQuaHocTapList) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.namVaoHoc = namVaoHoc;
        this.diemDauVao = diemDauVao;
        this.ketQuaHocTapList = ketQuaHocTapList;
    }
    public SinhVien(SinhVien other) {
        this.maSV = other.maSV;
        this.hoTen = other.hoTen;
        this.ngaySinh = other.ngaySinh;
        this.namVaoHoc = other.namVaoHoc;
        this.diemDauVao = other.diemDauVao;
        this.ketQuaHocTapList = other.ketQuaHocTapList;
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getNamVaoHoc() {
        return namVaoHoc;
    }
    public void setNamVaoHoc(String namVaoHoc) {
        this.namVaoHoc = namVaoHoc;
    }
    public Double getDiemDauVao() {
        return diemDauVao;
    }
    public void setDiemDauVao(Double diemDauVao) {
        this.diemDauVao = diemDauVao;
    }
    public List<KetQuaHocTap> getKetQuaHocTapList() {
        return ketQuaHocTapList;
    }
    public void setKetQuaHocTapList(List<KetQuaHocTap> ketQuaHocTapList) {
        this.ketQuaHocTapList = ketQuaHocTapList;
    }
    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", namVaoHoc='" + namVaoHoc + '\'' +
                ", diemDauVao=" + diemDauVao +
                ", ketQuaHocTapList=" + ketQuaHocTapList +
                '}';
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Nhap ma sinh vien: ");
            String maSV;
            while (true) {
                try {
                    maSV = scanner.nextLine().trim();
                    ValidInput.validateMaSV(maSV); // Assuming ValidInput is a utility class for validation
                    break; // Exit loop if input is valid
                } catch (CustomException.InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Nhap ho ten: ");
            String hoTen;
            while (true) {
                try {
                    hoTen = scanner.nextLine().trim();
                    ValidInput.validateHoTen(hoTen); // Assuming ValidInput is a utility class for validation
                    break; // Exit loop if input is valid
                } catch (CustomException.InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            String ngaySinh;
            while (true) {
                try {
                    ngaySinh = scanner.nextLine().trim();
                    ValidInput.validateNgaySinh(ngaySinh); // Assuming ValidInput is a utility class for validation
                    break; // Exit loop if input is valid
                } catch (CustomException.InvalidInputException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.print("Nhap nam vao hoc: ");
            String namVaoHoc = scanner.nextLine();
            System.out.print("Nhap diem dau vao: ");
            Double diemDauVao;
            try {
                diemDauVao = Double.parseDouble(scanner.nextLine());
                if (diemDauVao < 0 || diemDauVao > 10) {
                    System.out.println("Diem dau vao phai trong khoang [0, 10]. Vui long nhap lai.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Diem dau vao khong hop le. Vui long nhap lai.");
                continue;
            }
            System.out.println("Nhap so luong ket qua hoc tap:");
            int soLuongKetQua= scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            List<KetQuaHocTap> ketQuaHocTapList = getKetQuaHocTapList(); // Initialize or pass as needed
            for (int i = 0; i < soLuongKetQua; i++) {
                KetQuaHocTap ketQuaHocTap = new KetQuaHocTap();
                ketQuaHocTap.input(); // Assuming KetQuaHocTap has an input method
                ketQuaHocTapList.add(ketQuaHocTap);
            }
            this.maSV = maSV;
            this.hoTen = hoTen;
            this.ngaySinh = ngaySinh;
            this.namVaoHoc = namVaoHoc;
            this.diemDauVao = diemDauVao;
            this.ketQuaHocTapList = ketQuaHocTapList;
            break;
        }
    }
    public void output(){
        System.out.println("Ma sinh vien: " + maSV);
        System.out.println("Ho ten: " + hoTen);
        System.out.println("Ngay sinh: " + ngaySinh);
        System.out.println("Nam vao hoc: " + namVaoHoc);
        System.out.println("Diem dau vao: " + diemDauVao);
        if (ketQuaHocTapList != null && !ketQuaHocTapList.isEmpty()) {
            System.out.println("Ket qua hoc tap:");
            for (KetQuaHocTap ketQua : ketQuaHocTapList) {
                ketQua.output(); // Assuming KetQuaHocTap has an output method
            }
        } else {
            System.out.println("Khong co ket qua hoc tap.");
        }
    }
    public boolean isSinhVienChinhQuy() {
        return this instanceof SVChinhQuy;
    }

}
