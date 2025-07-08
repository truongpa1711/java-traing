package OOP.B14_QLTuyenSinh;

public class Exception {
    public static class InvalidScoreException extends Exception {
        public InvalidScoreException(String message) {
            super(message);
        }
    }

    public static class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message) {
            super(message);
        }
    }

    public static class InvalidIdException extends Exception {
        public InvalidIdException(String message) {
            super(message);
        }
    }
}
