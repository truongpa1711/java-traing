package OOP.B13_QLNV;

public class exception {
    public static class EmailException extends Exception {
        public EmailException(String message) {
            super(message);
        }
    }

    public static class PhoneException extends Exception {
        public PhoneException(String message) {
            super(message);
        }
    }

    public static class BirthDayException extends Exception {
        public BirthDayException(String message) {
            super(message);
        }
    }

    public static class FullNameException extends Exception {
        public FullNameException(String message) {
            super(message);
        }
    }
}
