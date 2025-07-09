package OOP.B11_SoPhuc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so phuc 1:");
        System.out.print("Nhap phan thuc: ");
        double phanThuc1 = scanner.nextDouble();
        System.out.print("Nhap phan ao: ");
        double phanAo1 = scanner.nextDouble();
        SoPhuc soPhuc1 = new SoPhuc(phanThuc1, phanAo1);
        System.out.println("Nhap so phuc 2:");
        System.out.print("Nhap phan thuc: ");
        double phanThuc2 = scanner.nextDouble();
        System.out.print("Nhap phan ao: ");
        double phanAo2 = scanner.nextDouble();
        SoPhuc soPhuc2 = new SoPhuc(phanThuc2, phanAo2);
        System.out.println("Hien thi so phuc 1: " + soPhuc1.getPhanThuc() + " + " + soPhuc1.getPhanAo() + "i");
        System.out.println("Hien thi so phuc 2: " + soPhuc2.getPhanThuc() + " + " + soPhuc2.getPhanAo() + "i");
        SoPhuc tong = new SoPhuc(soPhuc1.getPhanThuc() + soPhuc2.getPhanThuc(), soPhuc1.getPhanAo() + soPhuc2.getPhanAo());
        SoPhuc hieu = new SoPhuc(soPhuc1.getPhanThuc() - soPhuc2.getPhanThuc(), soPhuc1.getPhanAo() - soPhuc2.getPhanAo());
        SoPhuc tich = new SoPhuc(
            soPhuc1.getPhanThuc() * soPhuc2.getPhanThuc() - soPhuc1.getPhanAo() * soPhuc2.getPhanAo(),
            soPhuc1.getPhanThuc() * soPhuc2.getPhanAo() + soPhuc1.getPhanAo() * soPhuc2.getPhanThuc()
        );
        System.out.println("Tong: " + tong.getPhanThuc() + " + " + tong.getPhanAo() + "i");
        System.out.println("Hieu: " + hieu.getPhanThuc() + " + " + hieu.getPhanAo() + "i");
        System.out.println("Tich: " + tich.getPhanThuc() + " + " + tich.getPhanAo() + "i");
    }
}
