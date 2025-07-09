package OOP.B14_QLTuyenSinh;

public class ValidateInput {
    public static void ValidFullName(String name) throws CustomException.InvalidFullNameException  {
        if(name.length()<10|| name.length()>50) {
            throw new CustomException.InvalidFullNameException("Tên không hợp lệ. Tên phải có độ dài từ 10 đến 50 ký tự.");
        }
    }

    public static void ValidDateOfBirth(String DoB) throws CustomException.InvalidDOBException {
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (!DoB.matches(dateRegex)) {
            throw new CustomException.InvalidDOBException("Ngày sinh không hợp lệ. Định dạng đúng: dd/MM/yyyy");
        }
    }

    public static void validatePhoneNumber(String phone) throws CustomException.InvalidPhoneNumberException {
        String[] allowedPrefixes = {"090", "098", "091", "031", "035", "038"};

        // Kiểm tra độ dài và phải toàn số
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new CustomException.InvalidPhoneNumberException("Số điện thoại phải có đúng 10 chữ số.");
        }

        // Kiểm tra prefix
        boolean validPrefix = false;
        for (String prefix : allowedPrefixes) {
            if (phone.startsWith(prefix)) {
                validPrefix = true;
                break;
            }
        }

        if (!validPrefix) {
            throw new CustomException.InvalidPhoneNumberException("Số điện thoại phải bắt đầu bằng một trong các đầu số: 090, 098, 091, 031, 035, 038.");
        }
    }

}
