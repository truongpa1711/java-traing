package OOP.B15_QLKetQuaHocTap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLSV {
    private List<Khoa> danhSachKhoa;

    // Constructor mặc định
    public QLSV() {
        this.danhSachKhoa = new ArrayList<>();
    }

    // Constructor với tham số
    public QLSV(List<Khoa> danhSachKhoa) {
        this.danhSachKhoa = danhSachKhoa != null ? new ArrayList<>(danhSachKhoa) : new ArrayList<>();
    }

    // Getter và Setter
    public List<Khoa> getDanhSachKhoa() {
        return danhSachKhoa;
    }

    public void setDanhSachKhoa(List<Khoa> danhSachKhoa) {
        this.danhSachKhoa = danhSachKhoa != null ? new ArrayList<>(danhSachKhoa) : new ArrayList<>();
    }

    // Nhập dữ liệu cho danh sách khoa
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng khoa: ");
        int soLuongKhoa;
        try {
            soLuongKhoa = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (Exception e) {
            System.out.println("Số lượng khoa không hợp lệ. Vui lòng nhập lại.");
            scanner.nextLine(); // Clear invalid input
            return;
        }

        for (int i = 0; i < soLuongKhoa; i++) {
            System.out.println("Nhập thông tin khoa thứ " + (i + 1) + ":");
            Khoa khoa = new Khoa();
            khoa.input();
            danhSachKhoa.add(khoa);
        }
    }

    // Xuất dữ liệu danh sách khoa
    public void output() {
        if (danhSachKhoa == null || danhSachKhoa.isEmpty()) {
            System.out.println("Danh sách khoa trống.");
            return;
        }
        System.out.println("=== DANH SÁCH KHOA ===");
        for (Khoa khoa : danhSachKhoa) {
            khoa.output();
            System.out.println("---------------------");
        }
    }

    // Thêm một khoa vào danh sách
    public void themKhoa(Khoa khoa) {
        if (khoa != null && khoa.getTenKhoa() != null && !khoa.getTenKhoa().isEmpty()) {
            danhSachKhoa.add(khoa);
            System.out.println("Đã thêm khoa " + khoa.getTenKhoa() + " thành công.");
        } else {
            System.out.println("Khoa không hợp lệ.");
        }
    }

    // Xóa một khoa theo tên khoa
    public void xoaKhoa(String tenKhoa) {
        if (tenKhoa == null || tenKhoa.isEmpty()) {
            System.out.println("Tên khoa không hợp lệ.");
            return;
        }
        boolean removed = danhSachKhoa.removeIf(khoa -> khoa.getTenKhoa().equalsIgnoreCase(tenKhoa));
        if (removed) {
            System.out.println("Đã xóa khoa " + tenKhoa + " thành công.");
        } else {
            System.out.println("Không tìm thấy khoa " + tenKhoa + ".");
        }
    }

    // Tạo dữ liệu giả
    public void fakeData() {
        danhSachKhoa = new ArrayList<>();

        // Khoa 1: CNTT
        List<SinhVien> studentsCNTT = new ArrayList<>();
        // Sinh viên chính quy 1
        List<KetQuaHocTap> results1 = new ArrayList<>();
        results1.add(new KetQuaHocTap("HK1-2023", 8.5));
        results1.add(new KetQuaHocTap("HK2-2023", 7.8));
        studentsCNTT.add(new SVChinhQuy("SV001", "Nguyen Van An", "15/05/2001", "2023", 8.0, results1));

        // Sinh viên chính quy 2
        List<KetQuaHocTap> results2 = new ArrayList<>();
        results2.add(new KetQuaHocTap("HK1-2021", 6.5));
        results2.add(new KetQuaHocTap("HK2-2021", 7.0));
        results2.add(new KetQuaHocTap("HK1-2022", 8.0));
        studentsCNTT.add(new SVChinhQuy("SV002", "Tran Thi Binh", "22/03/2000", "2021", 7.5, results2));

        // Sinh viên tại chức 1
        List<KetQuaHocTap> results3 = new ArrayList<>();
        results3.add(new KetQuaHocTap("HK1-2022", 9.0));
        results3.add(new KetQuaHocTap("HK2-2022", 8.2));
        studentsCNTT.add(new SVTaiChuc("SV003", "Le Van Cuong", "10/12/1999", "2022", 6.8, results3, "Đồng Nai"));

        Khoa khoaCNTT = new Khoa("CNTT", studentsCNTT);
        danhSachKhoa.add(khoaCNTT);

        // Khoa 2: Kinh tế
        List<SinhVien> studentsKinhTe = new ArrayList<>();
        // Sinh viên chính quy 3
        List<KetQuaHocTap> results4 = new ArrayList<>();
        results4.add(new KetQuaHocTap("HK1-2022", 7.2));
        results4.add(new KetQuaHocTap("HK2-2022", 8.8));
        studentsKinhTe.add(new SVChinhQuy("SV004", "Pham Thi Dung", "05/07/2000", "2022", 9.0, results4));

        // Sinh viên tại chức 2
        List<KetQuaHocTap> results5 = new ArrayList<>();
        results5.add(new KetQuaHocTap("HK1-2020", 6.0));
        results5.add(new KetQuaHocTap("HK2-2020", 7.5));
        results5.add(new KetQuaHocTap("HK1-2021", 8.5));
        studentsKinhTe.add(new SVTaiChuc("SV005", "Hoang Van Em", "30/11/1998", "2020", 7.0, results5, "Cà Mau"));

        // Sinh viên tại chức 3
        List<KetQuaHocTap> results6 = new ArrayList<>();
        results6.add(new KetQuaHocTap("HK1-2021", 8.0));
        results6.add(new KetQuaHocTap("HK2-2021", 9.2));
        studentsKinhTe.add(new SVTaiChuc("SV006", "Vo Thi Phuong", "25/09/1999", "2021", 8.2, results6, "Đồng Nai"));

        Khoa khoaKinhTe = new Khoa("Kinh tế", studentsKinhTe);
        danhSachKhoa.add(khoaKinhTe);
    }

    // Main method
    public static void main(String[] args) {
        QLSV qlsv = new QLSV();
        Scanner scanner = new Scanner(System.in);

        // Tạo dữ liệu giả
        qlsv.fakeData();

        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ SINH VIÊN ===");
            System.out.println("1. Nhập danh sách khoa");
            System.out.println("2. Xuất danh sách khoa");
            System.out.println("3. Thêm khoa");
            System.out.println("4. Xóa khoa");
            System.out.println("5. Đếm số lượng sinh viên chính quy trong một khoa");
            System.out.println("6. Sinh viên có điểm đầu vào cao nhất trong một khoa");
            System.out.println("7. Danh sách sinh viên tại chức theo nơi đào tạo trong một khoa");
            System.out.println("8. Danh sách sinh viên có điểm trung bình >= 8.0 trong một khoa");
            System.out.println("9. Sinh viên có điểm trung bình cao nhất trong một khoa");
            System.out.println("10. Sắp xếp sinh viên theo loại trong một khoa");
            System.out.println("11. Sắp xếp sinh viên theo năm vào học trong một khoa");
            System.out.println("12. Danh sách sinh viên theo năm vào học trong một khoa");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine(); // Clear invalid input
                continue;
            }

            if (choice == 0) {
                System.out.println("Thoát chương trình.");
                scanner.close();
                return;
            }

            switch (choice) {
                case 1:
                    qlsv.input();
                    break;
                case 2:
                    qlsv.output();
                    break;
                case 3:
                    Khoa khoa = new Khoa();
                    khoa.input();
                    qlsv.themKhoa(khoa);
                    break;
                case 4:
                    System.out.print("Nhập tên khoa cần xóa: ");
                    String tenKhoa = scanner.nextLine();
                    qlsv.xoaKhoa(tenKhoa);
                    break;
                case 5:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa5 = scanner.nextLine();
                    Khoa khoa5 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa5))
                            .findFirst()
                            .orElse(null);
                    if (khoa5 != null) {
                        int soLuong = khoa5.getSoLuongSinhVienChinhQuy();
                        System.out.println("Số lượng sinh viên chính quy trong khoa " + tenKhoa5 + ": " + soLuong);
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa5);
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa6 = scanner.nextLine();
                    Khoa khoa6 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa6))
                            .findFirst()
                            .orElse(null);
                    if (khoa6 != null) {
                        SinhVien svMaxDiem = khoa6.getSinhVienDiemDauVaoCaoNhat();
                        if (svMaxDiem != null) {
                            System.out.println("Sinh viên có điểm đầu vào cao nhất trong khoa " + tenKhoa6 + ":");
                            svMaxDiem.output();
                        } else {
                            System.out.println("Không có sinh viên trong khoa " + tenKhoa6);
                        }
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa6);
                    }
                    break;
                case 7:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa7 = scanner.nextLine();
                    System.out.print("Nhập nơi đào tạo: ");
                    String noiDaoTao = scanner.nextLine();
                    Khoa khoa7 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa7))
                            .findFirst()
                            .orElse(null);
                    if (khoa7 != null) {
                        List<SinhVien> svTaiChucList = khoa7.getSinhVienTaiChucTheoNoiDaoTao(noiDaoTao);
                        if (!svTaiChucList.isEmpty()) {
                            System.out.println("Danh sách sinh viên tại chức tại " + noiDaoTao + " trong khoa " + tenKhoa7 + ":");
                            svTaiChucList.forEach(SinhVien::output);
                        } else {
                            System.out.println("Không có sinh viên tại chức tại " + noiDaoTao + " trong khoa " + tenKhoa7);
                        }
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa7);
                    }
                    break;
                case 8:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa8 = scanner.nextLine();
                    Khoa khoa8 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa8))
                            .findFirst()
                            .orElse(null);
                    if (khoa8 != null) {
                        List<SinhVien> svHighAvgList = khoa8.getListSinhVienDiemTrungBinhCaoNhat();
                        if (!svHighAvgList.isEmpty()) {
                            System.out.println("Danh sách sinh viên có điểm trung bình >= 8.0 trong khoa " + tenKhoa8 + ":");
                            svHighAvgList.forEach(SinhVien::output);
                        } else {
                            System.out.println("Không có sinh viên có điểm trung bình >= 8.0 trong khoa " + tenKhoa8);
                        }
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa8);
                    }
                    break;
                case 9:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa9 = scanner.nextLine();
                    Khoa khoa9 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa9))
                            .findFirst()
                            .orElse(null);
                    if (khoa9 != null) {
                        SinhVien svMaxAvg = khoa9.getSinhVienDiemTrungBinhCaoNhat();
                        if (svMaxAvg != null) {
                            System.out.println("Sinh viên có điểm trung bình cao nhất trong khoa " + tenKhoa9 + ":");
                            svMaxAvg.output();
                        } else {
                            System.out.println("Không có sinh viên có kết quả học tập trong khoa " + tenKhoa9);
                        }
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa9);
                    }
                    break;
                case 10:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa10 = scanner.nextLine();
                    Khoa khoa10 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa10))
                            .findFirst()
                            .orElse(null);
                    if (khoa10 != null) {
                        khoa10.sapXepDanhSachSinhVienTheoLoai();
                        System.out.println("Đã sắp xếp sinh viên theo loại (chính quy trước, tại chức sau) trong khoa " + tenKhoa10);
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa10);
                    }
                    break;
                case 11:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa11 = scanner.nextLine();
                    Khoa khoa11 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa11))
                            .findFirst()
                            .orElse(null);
                    if (khoa11 != null) {
                        khoa11.sapXepDanhSachSinhVienTheoNamVaoHoc();
                        System.out.println("Đã sắp xếp sinh viên theo năm vào học (giảm dần) trong khoa " + tenKhoa11);
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa11);
                    }
                    break;
                case 12:
                    System.out.print("Nhập tên khoa: ");
                    String tenKhoa12 = scanner.nextLine();
                    System.out.print("Nhập năm vào học: ");
                    String namVaoHoc = scanner.nextLine();
                    Khoa khoa12 = qlsv.getDanhSachKhoa().stream()
                            .filter(k -> k.getTenKhoa().equalsIgnoreCase(tenKhoa12))
                            .findFirst()
                            .orElse(null);
                    if (khoa12 != null) {
                        List<SinhVien> svNamVaoHocList = khoa12.getSinhVienTheoNamVaoHoc(namVaoHoc);
                        if (!svNamVaoHocList.isEmpty()) {
                            System.out.println("Danh sách sinh viên vào học năm " + namVaoHoc + " trong khoa " + tenKhoa12 + ":");
                            svNamVaoHocList.forEach(SinhVien::output);
                        } else {
                            System.out.println("Không có sinh viên vào học năm " + namVaoHoc + " trong khoa " + tenKhoa12);
                        }
                    } else {
                        System.out.println("Không tìm thấy khoa " + tenKhoa12);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}