package OOP.B12_QLPTGT;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        QLPTGT qlptgt = new QLPTGT();
        do {
            System.out.println("1. Them phuong tien");
            System.out.println("2. Xoa phuong tien theo ID");
            System.out.println("3. Tim kiem phuong tien theo hang san xuat");
            System.out.println("4. Tim kiem phuong tien theo mau");
            System.out.println("5. Hien thi danh sach phuong tien");
            System.out.println("6. Thoat");
            System.out.print("Nhap lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the newline character

            switch (choice) {
                case 1:
                    System.out.println("Nhap thong tin phuong tien:");
                    System.out.print("Hang san xuat: ");
                    String hangSanXuat = scanner.nextLine();
                    System.out.print("Nam san xuat: ");
                    String namSanXuat = scanner.nextLine();
                    System.out.print("Mau xe: ");
                    String mauXe = scanner.nextLine();
                    System.out.print("Gia ban: ");
                    double giaBan = scanner.nextDouble();
                    scanner.nextLine(); // Clear the newline character
                    System.out.print("Chon loai phuong tien (1: Oto, 2: Xe may, 3: Xe tai): ");
                    int loaiPT = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    switch (loaiPT) {
                        case 1:
                            System.out.print("So cho ngoi: ");
                            int soChoNgoi = scanner.nextInt();
                            scanner.nextLine(); // Clear the newline character
                            System.out.print("Kieu dong co: ");
                            String kieuDongCo = scanner.nextLine();
                            OTO oto = new OTO(hangSanXuat, namSanXuat, mauXe, giaBan, soChoNgoi, kieuDongCo);
                            qlptgt.themPhuongTien(oto);
                            break;
                        case 2:
                            System.out.print("Cong suat: ");
                            String congSuat = scanner.nextLine();
                            XEMAY xemay = new XEMAY(hangSanXuat, namSanXuat, mauXe, giaBan, congSuat);
                            qlptgt.themPhuongTien(xemay);
                            break;
                        case 3:
                            System.out.print("Tai trong: ");
                            double taiTrong = scanner.nextDouble();
                            XeTai xeTai = new XeTai(hangSanXuat, namSanXuat, mauXe, giaBan, taiTrong);
                            qlptgt.themPhuongTien(xeTai);
                            break;
                        default:
                            System.out.println("Loai phuong tien khong hop le.");
                    }

                    break;
                case 2:
                    System.out.print("Nhap ID phuong tien can xoa: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character
                    if (qlptgt.xoaPhuongTien(idToDelete)) {
                        System.out.println("Xoa phuong tien thanh cong.");
                    } else {
                        System.out.println("Khong tim thay phuong tien voi ID: " + idToDelete);
                    }
                    break;
                case 3:
                    System.out.print("Nhap hang san xuat can tim: ");
                    String hangSanXuatTim = scanner.nextLine();

                    List<PhuongTien>phuongTienList=qlptgt.timPhuonTienTheoHangSanXuat(hangSanXuatTim);
                    if (phuongTienList.isEmpty()) {
                        System.out.println("Khong tim thay phuong tien voi hang san xuat: " + hangSanXuatTim);
                    } else {
                        System.out.println("Danh sach phuong tien:");
                        for (PhuongTien pt : phuongTienList) {
                            System.out.println(pt);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Nhap mau xe can tim: ");
                    String mauXeTim = scanner.nextLine();
                    List<PhuongTien> phuongTienMauList = qlptgt.timPhuongTienTheoMau(mauXeTim);
                    if (phuongTienMauList.isEmpty()) {
                        System.out.println("Khong tim thay phuong tien voi mau: " + mauXeTim);
                    } else {
                        System.out.println("Danh sach phuong tien:");
                        for (PhuongTien pt : phuongTienMauList) {
                            System.out.println(pt);
                        }
                    }
                    break;
                case 5:
                    qlptgt.inDanhSachPhuongTien();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        } while (choice != 6);

    }
}
