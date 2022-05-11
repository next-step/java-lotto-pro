package study.step2.exception;

public class NumberConversionException extends RuntimeException {
    public NumberConversionException(String message) {
        super(message);
    }
}