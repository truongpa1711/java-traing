package OOP.B5_QLKHACHSAN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class KHACHSAN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choin = 0;
        ArrayList<Phong> dsPhong = new ArrayList<>();
        HashSet<String> soCmSet = new HashSet<>();
        do {
            System.out.println("Chon chuc nang: ");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xem danh sach khach hang");
            System.out.println("3. Xoa khach hang theo so CMND");
            System.out.println("4. Tính tien phong cho khach hang theo so CMND");
            System.out.println("5. Thoat");
            System.out.println("=====================================");
            System.out.print("Nhap lua chon cua ban: ");
            // Read the choice from the user
            try {
                choin = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang, vui long nhap lai.");
                scanner.nextLine(); // Clear the invalid input
                continue; // Skip to the next iteration of the loop
            }
            switch (choin) {
                case 1:
                    Nguoi khach = new Nguoi();
                    Phong phong = new Phong();
                    System.out.println("Them khach hang moi.");
                    System.out.print("Nhap ho ten: ");
                    scanner.nextLine(); // Clear the newline character
                    khach.setHoTen(scanner.nextLine());
                    System.out.print("Nhap tuoi: ");
                    khach.setTuoi(scanner.nextInt());
                    scanner.nextLine(); // Clear the newline character
                    String soCm;
                    do {
                        System.out.print("Nhap so CMND: ");
                        soCm = scanner.nextLine();
                        if (soCmSet.contains(soCm)) {
                            System.out.println("So CMND da ton tai, vui long nhap lai.");
                        }
                    } while (soCmSet.contains(soCm));
                    khach.setSoCm(soCm);
                    soCmSet.add(soCm);
                    System.out.print("Nhap so ngay thue: ");
                    phong.setSoNgayThue(scanner.nextInt());
                    scanner.nextLine(); // Clear the newline character
                    System.out.println("Chon loai phong: ");
                    System.out.println("1. Phong A (500$)");
                    System.out.println("2. Phong B (300$)");
                    System.out.println("3. Phong C (100$)");
                    int loaiPhongChoice;
                    do {
                        System.out.print("Nhap lua chon loai phong: ");
                        loaiPhongChoice = scanner.nextInt();
                        switch (loaiPhongChoice) {
                            case 1:
                                phong.setLoaiPhong(Phong.LoaiPhong.A);
                                break;
                            case 2:
                                phong.setLoaiPhong(Phong.LoaiPhong.B);
                                break;
                            case 3:
                                phong.setLoaiPhong(Phong.LoaiPhong.C);
                                break;
                            default:
                                System.out.println("Lua chon khong hop le, vui long chon lai.");
                        }
                    } while (loaiPhongChoice < 1 || loaiPhongChoice > 3);
                    phong.setKhach(khach);
                    dsPhong.add(phong);
                    System.out.println("Them khach hang thanh cong.");
                    break;
                case 2:
                    System.out.println("Danh sach khach hang:");
                    if (dsPhong.isEmpty()) {
                        System.out.println("Khong co khach hang nao trong danh sach.");
                    } else {
                        for (Phong p : dsPhong) {
                            Nguoi k = p.getKhach();
                            System.out.println("Ho ten: " + k.getHoTen() + ", Tuoi: " + k.getTuoi() +
                                               ", So CMND: " + k.getSoCm() + ", So ngay thue: " + p.getSoNgayThue() +
                                               ", Loai phong: " + p.getLoaiPhong());
                            System.out.println("------------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap so CMND cua khach hang can xoa: ");
                    scanner.nextLine(); // Clear the newline character
                    String cmToDelete = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < dsPhong.size(); i++) {
                        if (dsPhong.get(i).getKhach().getSoCm().equals(cmToDelete)) {
                            dsPhong.remove(i);
                            soCmSet.remove(cmToDelete);
                            System.out.println("Xoa khach hang thanh cong.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong tim thay khach hang voi so CMND: " + cmToDelete);
                    }
                    break;
                case 4:
                    System.out.print("Nhap so CMND cua khach hang can tinh tien: ");
                    scanner.nextLine(); // Clear the newline character
                    String cmToCalculate = scanner.nextLine();
                    boolean foundForCalculation = false;
                    for (Phong p : dsPhong) {
                        if (p.getKhach().getSoCm().equals(cmToCalculate)) {
                            int total = p.tinhTien();
                            System.out.println("Tong tien phong cho khach hang " + p.getKhach().getHoTen() +
                                               " la: " + total + "$");
                            foundForCalculation = true;
                            break;
                        }
                    }
                    if (!foundForCalculation) {
                        System.out.println("Khong tim thay khach hang voi so CMND: " + cmToCalculate);
                    }
                    break;
                case 5:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        } while (choin != 5);
    }
}
