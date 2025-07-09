package OOP.B2_QuanLySach;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TaiLieu> taiLieus = new ArrayList<>();
        int choice;
        while (true) {
            System.out.println("Chương trình quản lý tài liệu");
            System.out.println("1. Thêm tài liệu: Sách, Tạp chí, Báo");
            System.out.println("2. Hiển thị tài liệu");
            System.out.println("3. Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.");
            System.out.println("4. Thoát");
            System.out.println("---------------------------------");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("Vui lòng nhập một số nguyên từ 1 đến 5.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số nguyên từ 1 đến 5.");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Chọn loại tài liệu:");
                    System.out.println("1. Sách");
                    System.out.println("2. Tạp chí");
                    System.out.println("3. Báo");

                    while (true) {
                        System.out.println("Nhập 'none' để quay lại menu chính.");
                        System.out.println("Nhập 'exit' để thoát chương trình.");
                        System.out.println("---------------------------------");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("none")) {
                            break;
                        } else if (input.equalsIgnoreCase("exit")) {
                            System.out.println("Thoát chương trình.");
                            return;
                        }
                        int loaiTaiLieu;
                        try {
                            loaiTaiLieu = Integer.parseInt(input);
                            if (loaiTaiLieu < 1 || loaiTaiLieu > 3) {
                                System.out.println("Vui lòng nhập một số nguyên từ 1 đến 3.");
                                continue;
                            }
                            System.out.print("Nhập tên nhà xuất bản: ");
                            String tenNhaXuatBan = scanner.nextLine();
                            System.out.print("Nhập số bản phát hành: ");
                            int soBanPhatHanh = Integer.parseInt(scanner.nextLine());
                            if (loaiTaiLieu == 1) {
                                System.out.print("Nhập tên tác giả: ");
                                String tenTacGia = scanner.nextLine();
                                System.out.print("Nhập số trang: ");
                                int soTrang = Integer.parseInt(scanner.nextLine());
                                taiLieus.add(new Sach(tenNhaXuatBan, soBanPhatHanh, tenTacGia, soTrang));
                            } else if (loaiTaiLieu == 2) {
                                System.out.print("Nhập số phát hành: ");
                                int soPhatHanh = Integer.parseInt(scanner.nextLine());
                                System.out.print("Nhập tháng phát hành: ");
                                String thangPhatHanh = scanner.nextLine();
                                taiLieus.add(new TapChi(tenNhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh));
                            } else if (loaiTaiLieu == 3) {
                                System.out.print("Nhập ngày phát hành: ");
                                String ngayPhatHanh = scanner.nextLine();
                                taiLieus.add(new Bao(tenNhaXuatBan, soBanPhatHanh, ngayPhatHanh));
                            }
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập một số nguyên từ 1 đến 3.");
                            continue;
                        }
                    }
                    break;
                case 2:
                    if (taiLieus.isEmpty()) {
                        System.out.println("Không có tài liệu nào để hiển thị.");
                    } else {
                        System.out.println("Danh sách tài liệu:");
                        for (TaiLieu taiLieu : taiLieus) {
                            System.out.println("ID: " + taiLieu.getMaTaiLieu());
                            System.out.println("Tên nhà xuất bản: " + taiLieu.getTenNhaXuatBan());
                            System.out.println("Số bản phát hành: " + taiLieu.getSoBanPhatHanh());
                            if (taiLieu instanceof Sach) {
                                Sach sach = (Sach) taiLieu;
                                System.out.println("Tên tác giả: " + sach.getTenTacGia());
                                System.out.println("Số trang: " + sach.getSoTrang());
                            } else if (taiLieu instanceof TapChi) {
                                TapChi tapChi = (TapChi) taiLieu;
                                System.out.println("Số phát hành: " + tapChi.getSoPhatHanh());
                                System.out.println("Tháng phát hành: " + tapChi.getThangPhatHanh());
                            } else if (taiLieu instanceof Bao) {
                                Bao bao = (Bao) taiLieu;
                                System.out.println("Ngày phát hành: " + bao.getNgayPhatHanh());
                            }
                            System.out.println("---------------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Chọn loại tài liệu để tìm kiếm:");
                    System.out.println("1. Sách");
                    System.out.println("2. Tạp chí");
                    System.out.println("3. Báo");
                    System.out.print("Nhập lựa chọn của bạn: ");
                    int loaiTimKiem;
                    try {
                        loaiTimKiem = Integer.parseInt(scanner.nextLine());
                        if (loaiTimKiem < 1 || loaiTimKiem > 3) {
                            System.out.println("Vui lòng nhập một số nguyên từ 1 đến 3.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập một số nguyên từ 1 đến 3.");
                        continue;
                    }
                    boolean found = false;
                    for (TaiLieu taiLieu : taiLieus) {
                        if(loaiTimKiem == 1 && taiLieu instanceof Sach) {
                            Sach sach = (Sach) taiLieu;
                            System.out.println("ID: " + sach.getMaTaiLieu());
                            System.out.println("Tên nhà xuất bản: " + sach.getTenNhaXuatBan());
                            System.out.println("Số bản phát hành: " + sach.getSoBanPhatHanh());
                            System.out.println("Tên tác giả: " + sach.getTenTacGia());
                            System.out.println("Số trang: " + sach.getSoTrang());
                            System.out.println("---------------------------------");
                            found = true;
                        } else if(loaiTimKiem == 2 && taiLieu instanceof TapChi) {
                            TapChi tapChi = (TapChi) taiLieu;
                            System.out.println("ID: " + tapChi.getMaTaiLieu());
                            System.out.println("Tên nhà xuất bản: " + tapChi.getTenNhaXuatBan());
                            System.out.println("Số bản phát hành: " + tapChi.getSoBanPhatHanh());
                            System.out.println("Số phát hành: " + tapChi.getSoPhatHanh());
                            System.out.println("Tháng phát hành: " + tapChi.getThangPhatHanh());
                            System.out.println("---------------------------------");
                            found = true;
                        } else if(loaiTimKiem == 3 && taiLieu instanceof Bao) {
                            Bao bao = (Bao) taiLieu;
                            System.out.println("ID: " + bao.getMaTaiLieu());
                            System.out.println("Tên nhà xuất bản: " + bao.getTenNhaXuatBan());
                            System.out.println("Số bản phát hành: " + bao.getSoBanPhatHanh());
                            System.out.println("Ngày phát hành: " + bao.getNgayPhatHanh());
                            System.out.println("---------------------------------");
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy tài liệu nào.");
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

            }
        }
    }
}
