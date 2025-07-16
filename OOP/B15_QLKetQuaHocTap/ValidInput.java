package OOP.B15_QLKetQuaHocTap;

public class ValidInput {
    public static void validateMaSV(String maSV) throws CustomException.InvalidInputException {
        if (maSV == null || maSV.isEmpty()) {
            throw new CustomException.InvalidInputException("Mã sinh viên không được để trống.");
        }
    }
    public static void validateHoTen(String hoTen) throws CustomException.InvalidInputException {
        if (hoTen == null || hoTen.isEmpty()) {
            throw new CustomException.InvalidInputException("Họ tên không được để trống.");
        }
        String regex = "^[a-zA-Z\\s]+$";
        if (!hoTen.matches(regex)) {
            throw new CustomException.InvalidInputException("Họ tên chỉ được chứa chữ cái và khoảng trắng.");
        }
        if(hoTen.length() < 3 || hoTen.length() > 50) {
            throw new CustomException.InvalidInputException("Họ tên phải có độ dài từ 3 đến 50 ký tự.");
        }
    }
    public static void validateNgaySinh(String ngaySinh) throws CustomException.InvalidInputException {
        if (ngaySinh == null || ngaySinh.isEmpty()) {
            throw new CustomException.InvalidInputException("Ngày sinh không được để trống.");
        }
        String regex = "\\d{2}/\\d{2}/\\d{4}";
        if (!ngaySinh.matches(regex)) {
            throw new CustomException.InvalidInputException("Ngày sinh phải theo định dạng dd/MM/yyyy.");
        }
    }

}
