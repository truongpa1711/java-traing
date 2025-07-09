package OOP.B3_TuyenSinh;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<ThiSinh> thiSinhs = new ArrayList<>();
        while (true){
            System.out.println("1. Them thong tin thi sinh");
            System.out.println("2. Hien thi danh sach thi sinh và khoi thi");
            System.out.println("3. Tim kiem thi sinh theo SBD");
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
                    System.out.print("Nhap ho ten: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhap dia chi: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhap muc uu tien: ");
                    String mucUuTien = scanner.nextLine();

                    System.out.println("Chon khoi thi:");
                    System.out.println("1. Khoi A");
                    System.out.println("2. Khoi B");
                    System.out.println("3. Khoi C");

                    int khoi;
                    while (true) {
                        System.out.print("Nhap lua chon khoi thi (1-3): ");
                        try {
                            khoi = Integer.parseInt(scanner.nextLine());
                            if (khoi < 1 || khoi > 3) {
                                System.out.println("Vui long nhap mot so nguyen tu 1 den 3.");
                                continue;
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui long nhap mot so nguyen tu 1 den 3.");
                        }
                    }

                    if (khoi == 1) {
                        System.out.print("Nhap diem toan: ");
                        double toan = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem ly: ");
                        double ly = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem hoa: ");
                        double hoa = Double.parseDouble(scanner.nextLine());
                        thiSinhs.add(new KhoiA(hoTen, diaChi, mucUuTien, toan, ly, hoa));
                    } else if (khoi == 2) {
                        System.out.print("Nhap diem toan: ");
                        double toan = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem hoa: ");
                        double hoa = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem sinh: ");
                        double sinh = Double.parseDouble(scanner.nextLine());
                        thiSinhs.add(new KhoiB(hoTen, diaChi, mucUuTien, toan, hoa, sinh));
                    } else if (khoi == 3) {
                        System.out.print("Nhap diem van: ");
                        double van = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem su: ");
                        double su = Double.parseDouble(scanner.nextLine());
                        System.out.print("Nhap diem dia: ");
                        double dia = Double.parseDouble(scanner.nextLine());
                        thiSinhs.add(new KhoiC(hoTen, diaChi, mucUuTien, van, su, dia));
                    }
                    System.out.println("Them thong tin thi sinh thanh cong!");
                    break;
                case 2:
                    if (thiSinhs.isEmpty()) {
                        System.out.println("Danh sach thi sinh rong.");
                    } else {
                        System.out.println("Danh sach thi sinh:");
                        for (ThiSinh ts : thiSinhs) {
                            System.out.println("SBD: " + ts.getSBD());
                            System.out.println("Ho ten: " + ts.getHoTen());
                            System.out.println("Dia chi: " + ts.getDiaChi());
                            System.out.println("Muc uu tien: " + ts.getMucUuTien());
                            if (ts instanceof KhoiA) {
                                KhoiA khoiA = (KhoiA) ts;
                                System.out.println("Khoi A - Toan: " + khoiA.getToan() + ", Ly: " + khoiA.getLy() + ", Hoa: " + khoiA.getHoa());
                            } else if (ts instanceof KhoiB) {
                                KhoiB khoiB = (KhoiB) ts;
                                System.out.println("Khoi B - Toan: " + khoiB.getToan() + ", Hoa: " + khoiB.getHoa() + ", Sinh: " + khoiB.getSinh());
                            } else if (ts instanceof KhoiC) {
                                KhoiC khoiC = (KhoiC) ts;
                                System.out.println("Khoi C - Van: " + khoiC.getVan() + ", Su: " + khoiC.getSu() + ", Dia: " + khoiC.getDia());
                            }
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhap SBD can tim: ");
                    String sbd = scanner.nextLine();
                    boolean found = false;
                    for (ThiSinh ts : thiSinhs) {
                        if (ts.getSBD().equals(sbd)) {
                            System.out.println("Thong tin thi sinh:");
                            System.out.println("SBD: " + ts.getSBD());
                            System.out.println("Ho ten: " + ts.getHoTen());
                            System.out.println("Dia chi: " + ts.getDiaChi());
                            System.out.println("Muc uu tien: " + ts.getMucUuTien());
                            if (ts instanceof KhoiA) {
                                KhoiA khoiA = (KhoiA) ts;
                                System.out.println("Khoi A - Toan: " + khoiA.getToan() + ", Ly: " + khoiA.getLy() + ", Hoa: " + khoiA.getHoa());
                            } else if (ts instanceof KhoiB) {
                                KhoiB khoiB = (KhoiB) ts;
                                System.out.println("Khoi B - Toan: " + khoiB.getToan() + ", Hoa: " + khoiB.getHoa() + ", Sinh: " + khoiB.getSinh());
                            } else if (ts instanceof KhoiC) {
                                KhoiC khoiC = (KhoiC) ts;
                                System.out.println("Khoi C - Van: " + khoiC.getVan() + ", Su: " + khoiC.getSu() + ", Dia: " + khoiC.getDia());
                            }
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Khong tim thay thi sinh voi SBD: " + sbd);
                    }
                    break;
                case 4:
                    System.out.println("Thoat chuong trinh.");
                    return;
            }
        }
    }
}
