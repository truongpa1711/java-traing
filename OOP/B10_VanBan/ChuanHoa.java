package OOP.B10_VanBan;

public class ChuanHoa {
    public int soTu(VanBan vb) {
        String text = vb.getKt();
        if (text == null || text.isEmpty()) {
            return 0;
        }

        // Chia chuỗi thành mảng từ
        String[] words = text.trim().split("\\s+");

        // Trả về số lượng từ
        return words.length;
    }

    public int countCharA(VanBan vb) {
        String text = vb.getKt();
        if (text == null || text.isEmpty()) {
            return 0;
        }
        int count = 0;
        // Duyệt qua từng ký tự trong chuỗi
        for (char c : text.toCharArray()) {
            // Kiểm tra xem ký tự có phải là 'a' hay không
            if (c == 'a' || c == 'A') {
                count++;
            }
        }
        // Trả về số lượng ký tự 'a'
        return count;
    }

    public VanBan chuanHoaVanBan(VanBan vb) {
        String text = vb.getKt();
        if (text == null || text.isEmpty()) {
            return new VanBan("");
        }

        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word).append(" ");
        }

        return new VanBan(sb.toString().trim());
    }

}
