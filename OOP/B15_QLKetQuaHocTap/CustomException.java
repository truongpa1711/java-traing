package OOP.B15_QLKetQuaHocTap;

public class CustomException {
    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }
}
