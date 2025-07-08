package OOP.B10_VanBan;

public class Main {
    public static void main(String[] args) {
        VanBan vanBan = new VanBan("            Hello           World AAAAAAA  ");
        System.out.println("VanBan 1: " + vanBan.getKt());
        ChuanHoa chuanHoa = new ChuanHoa();
        System.out.println("So tu: " + chuanHoa.soTu(vanBan));
        System.out.println("So ky tu 'a': " + chuanHoa.countCharA(vanBan));
        VanBan chuanHoaVanBan = chuanHoa.chuanHoaVanBan(vanBan);
        System.out.println("VanBan sau chuan hoa: " + chuanHoaVanBan.getKt());

    }
}
