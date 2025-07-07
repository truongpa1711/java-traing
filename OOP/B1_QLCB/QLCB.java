package OOP.B1_QLCB;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<CanBo> canBoList = new ArrayList<>();

        while (true){
            System.out.println("Chuong trinh quan ly can bo");
            System.out.println("1. Them can bo");
            System.out.println("2. Tim kiem can bo theo ten");
            System.out.println("3. Hien thi danh sach can bo");
            System.out.println("4. Thoat");
            System.out.println("---------------------------------");
            System.out.print("Nhap lua chon cua ban: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 4) {
                    System.out.println("Vui long nhap mot so nguyen tu 1 den 4.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen tu 1 den 4.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Chon loai can bo:");
                    System.out.println("1. Cong Nhan");
                    System.out.println("2. Ky Su");
                    System.out.println("3. Nhan Vien");
                    System.out.println("none. Khác");
                    System.out.print("Nhap lua chon cua ban: ");
                    int loaiCanBo;
                    try {
                        loaiCanBo = Integer.parseInt(scanner.nextLine());
                        if (loaiCanBo < 1 || loaiCanBo > 3) {
                            System.out.println("Vui long nhap mot so nguyen tu 1 den 3.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Vui long nhap mot so nguyen tu 1 den 3.");
                        continue;
                    }

                    System.out.print("Nhap ho ten: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhap tuoi: ");
                    int tuoi= scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character

                    CanBo.gioitinh gioiTinh;
                    while (true) {
                        System.out.print("Nhap gioi tinh (1. NAM, 2. NU, 3. KHAC): ");
                        String gioiTinhInput = scanner.nextLine();
                        if (gioiTinhInput.equals("1")) {
                            gioiTinh = CanBo.gioitinh.NAM;
                            break;
                        } else if (gioiTinhInput.equals("2")) {
                            gioiTinh = CanBo.gioitinh.NU;
                            break;
                        } else if (gioiTinhInput.equals("3")) {
                            gioiTinh = CanBo.gioitinh.KHAC;
                            break;
                        } else {
                            System.out.println("Lua chon khong hop le, vui long chon lai.");
                        }
                    }

                    System.out.print("Nhap dia chi: ");
                    String diaChi = scanner.nextLine();
                    CanBo canBo = null; // Initialize canBo to null
                    switch (loaiCanBo) {
                        case 1:
                            System.out.print("Nhap bac cong nhan(1-10): ");
                            int bac = scanner.nextInt();
                            scanner.nextLine(); // Clear the newline character
                            canBo = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
                            break;
                        case 2:
                            System.out.print("Nhap nganh dao tao: ");
                            String nganhDaoTao = scanner.nextLine();
                            canBo = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
                            break;
                        case 3:
                            System.out.print("Nhap cong viec: ");
                            String congViec = scanner.nextLine();
                            canBo = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le.");
                            continue;
                    }
                    canBoList.add(canBo);
                    break;
                case 2:
                    if (canBoList.isEmpty()) {
                        System.out.println("Danh sach can bo rong. Khong the tim kiem.");
                        continue;
                    }
                    System.out.print("Nhap ten can bo can tim: ");
                    String tenCanBo = scanner.nextLine();
                    boolean found = false;
                    for (CanBo canBoItem : canBoList) {
                        if (canBoItem.getHoTen().equalsIgnoreCase(tenCanBo)) {
                            System.out.println("Can bo tim thay: ");
                            System.out.println("Ho ten: " + canBoItem.getHoTen() +
                                    ", Tuoi: " + canBoItem.getTuoi() +
                                    ", Gioi tinh: " + canBoItem.getGioiTinh() +
                                    ", Dia chi: " + canBoItem.getDiaChi());
                            if (canBoItem instanceof CongNhan) {
                                System.out.println("Bac cong nhan: " + ((CongNhan) canBoItem).getBac());
                            } else if (canBoItem instanceof KySu) {
                                System.out.println("Nganh dao tao: " + ((KySu) canBoItem).getNganhDaoTao());
                            } else if (canBoItem instanceof NhanVien) {
                                System.out.println("Cong viec: " + ((NhanVien) canBoItem).getCongViec());
                            }
                            System.out.println("---------------------------------");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong tim thay can bo voi ten: " + tenCanBo);
                    }

                    break;
                case 3:
                    System.out.println("Danh sach can bo:");
                    if (canBoList.isEmpty()) {
                        System.out.println("Khong co can bo nao trong danh sach.");
                    } else {
                        for (CanBo canBoItem : canBoList) {
                            System.out.println("Ho ten: " + canBoItem.getHoTen() +
                                    ", Tuoi: " + canBoItem.getTuoi() +
                                    ", Gioi tinh: " + canBoItem.getGioiTinh() +
                                    ", Dia chi: " + canBoItem.getDiaChi());
                            if (canBoItem instanceof CongNhan) {
                                System.out.println("Bac cong nhan: " + ((CongNhan) canBoItem).getBac());
                            } else if (canBoItem instanceof KySu) {
                                System.out.println("Nganh dao tao: " + ((KySu) canBoItem).getNganhDaoTao());
                            } else if (canBoItem instanceof NhanVien) {
                                System.out.println("Cong viec: " + ((NhanVien) canBoItem).getCongViec());
                            }
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        }
    }
}
