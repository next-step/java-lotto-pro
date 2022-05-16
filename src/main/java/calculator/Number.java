package calculator;

public class Number {

    public static final int ZERO = 0;
    private final static String VALIDATION_REG = "^(0|[1-9]+[0-9]*)$";

    private final int value;

    public Number(String input) {
        this.value = parseValue(input);
    }

    private int parseValue(String input) {
        if(!input.matches(VALIDATION_REG)) {
            throw new IllegalArgumentException("숫자 이외의 값 또는 음수는 입력할 수 없습니다.");
        }

        return Integer.parseInt(input);
    }

    public int getValue() {
        return value;
    }

}
