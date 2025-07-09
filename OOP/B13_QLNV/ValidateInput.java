package OOP.B13_QLNV;

public class ValidateInput {

    public static void validateEmail(String email) throws exception.EmailException {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!email.matches(emailRegex)) {
            throw new exception.EmailException("Email không hợp lệ. Định dạng phải là example@domain.com");
        }
    }

    public static void validatePhone(String phone) throws exception.PhoneException {
        String phoneRegex = "^(\\+?\\d{1,3})?[-.\\s]?\\(?\\d{1,4}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
        if (!phone.matches(phoneRegex)) {
            throw new exception.PhoneException("Số điện thoại không hợp lệ. Vui lòng nhập đúng định dạng.");
        }
    }

    public static void validateBirthDay(String birthDay) throws exception.BirthDayException {
        String birthDayRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (!birthDay.matches(birthDayRegex)) {
            throw new exception.BirthDayException("Ngày sinh không hợp lệ. Định dạng đúng: dd/MM/yyyy");
        }
    }

    public static void validateFullName(String fullName) throws exception.FullNameException {
        String fullNameRegex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";
        if (!fullName.matches(fullNameRegex)) {
            throw new exception.FullNameException("Họ tên không hợp lệ. Viết hoa chữ cái đầu mỗi từ.");
        }
    }
}
