package calculator;

public class Number {

    private final int number;

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력 가능합니다.");
        }
    }

    public int value() {
        return number;
    }
}
