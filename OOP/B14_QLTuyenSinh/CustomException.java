package OOP.B14_QLTuyenSinh;

public class CustomException {
    public static class InvalidFullNameException  extends Exception {
        public InvalidFullNameException (String message) {
            super(message);
        }
    }

    public static class InvalidDOBException  extends Exception {
        public InvalidDOBException (String message) {
            super(message);
        }
    }

    public static class InvalidPhoneNumberException  extends Exception {
        public InvalidPhoneNumberException (String message) {
            super(message);
        }
    }
}