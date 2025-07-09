package OOP.B15_QLKetQuaHocTap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Khoa {
    protected String tenKhoa;
    protected List<SinhVien> danhSachSinhVien;

    public Khoa() {
    }
    public Khoa(String tenKhoa, List<SinhVien> danhSachSinhVien) {
        this.tenKhoa = tenKhoa;
        this.danhSachSinhVien = danhSachSinhVien;
    }
    public Khoa(Khoa other) {
        this.tenKhoa = other.tenKhoa;
        this.danhSachSinhVien = new ArrayList<>(other.danhSachSinhVien);
    }
    public String getTenKhoa() {
        return tenKhoa;
    }
    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }
    public void setDanhSachSinhVien(List<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }
    @Override
    public String toString() {
        return "Khoa{" +
                "tenKhoa='" + tenKhoa + '\'' +
                ", danhSachSinhVien=" + danhSachSinhVien +
                '}';
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten khoa: ");
        this.tenKhoa = scanner.nextLine();
        System.out.print("Nhap so luong sinh vien: ");
        int soLuong = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhap thong tin sinh vien thu " + (i + 1) + ":");
            System.out.println("Choose type of student (1: Chinh Quy, 2: Tai Chuc): ");
            int type = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            SinhVien sinhVien;
            if (type == 1) {
                sinhVien = new SVChinhQuy();
            } else if (type == 2) {
                sinhVien = new SVTaiChuc();
            } else {
                System.out.println("Loai sinh vien khong hop le. Vui long chon lai.");
                i--; // Decrement i to repeat this iteration
                continue;
            }
            sinhVien.input();
            danhSachSinhVien.add(sinhVien);
        }
    }
    public void output() {
        // Display logic for Khoa
        System.out.println("Ten Khoa: " + tenKhoa);
        System.out.println("Danh sach sinh vien: " );
        for (SinhVien sv : danhSachSinhVien) {
            sv.output();
        }
    }

    public int getSoLuongSinhVienChinhQuy() {
        return (int) danhSachSinhVien.stream()
                .filter(sv -> sv instanceof SVChinhQuy)
                .count();
    }

    public SinhVien getSinhVienDiemDauVaoCaoNhat() {
        return danhSachSinhVien.stream()
                .max((sv1, sv2) -> Double.compare(sv1.getDiemDauVao(), sv2.getDiemDauVao()))
                .orElse(null);
    }

    public List<SinhVien> getSinhVienTaiChucTheoNoiDaoTao(String noiDaoTao) {
        return danhSachSinhVien.stream()
                .filter(sv -> sv instanceof SVTaiChuc && ((SVTaiChuc) sv).getNoiDaoTao().equalsIgnoreCase(noiDaoTao))
                .toList();
    }

    public List<SinhVien> getListSinhVienDiemTrungBinhCaoNhat() {
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getKetQuaHocTapList() != null && !sv.getKetQuaHocTapList().isEmpty())
                .filter(sv -> {
                    KetQuaHocTap lastResult = sv.getKetQuaHocTapList().get(sv.getKetQuaHocTapList().size() - 1);
                    return lastResult.getDiemTrungBinh() >= 8.0;
                })
                .toList();
    }

    public SinhVien getSinhVienDiemTrungBinhCaoNhat(){
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getKetQuaHocTapList() != null && !sv.getKetQuaHocTapList().isEmpty())
                .max((sv1, sv2) -> {
                    Double avg1 = sv1.getKetQuaHocTapList().stream()
                            .mapToDouble(KetQuaHocTap::getDiemTrungBinh)
                            .average()
                            .orElse(0.0);
                    Double avg2 = sv2.getKetQuaHocTapList().stream()
                            .mapToDouble(KetQuaHocTap::getDiemTrungBinh)
                            .average()
                            .orElse(0.0);
                    return Double.compare(avg1, avg2);
                })
                .orElse(null);
    }

//    sắp xếp danh sách sinh viên tăng dần theo loại
    public void sapXepDanhSachSinhVienTheoLoai() {
        danhSachSinhVien.sort((sv1, sv2) -> {
            if (sv1 instanceof SVChinhQuy && sv2 instanceof SVTaiChuc) {
                return -1; // SVChinhQuy trước SVTaiChuc
            } else if (sv1 instanceof SVTaiChuc && sv2 instanceof SVChinhQuy) {
                return 1; // SVTaiChuc sau SVChinhQuy
            } else {
                return 0; // Cùng loại hoặc không xác định
            }
        });
    }
    //Sap xep danh sach sinh vien giam dan theo nam vao hoc
    public void sapXepDanhSachSinhVienTheoNamVaoHoc() {
        danhSachSinhVien.sort((sv1, sv2) -> sv2.getNamVaoHoc().compareTo(sv1.getNamVaoHoc()));
    }

    //Lấy sinh viên theo năm vào học
    public List<SinhVien> getSinhVienTheoNamVaoHoc(String namVaoHoc) {
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getNamVaoHoc().equalsIgnoreCase(namVaoHoc))
                .toList();
    }

}
