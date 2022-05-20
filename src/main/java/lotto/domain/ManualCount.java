package lotto.domain;

public class ManualCount {
    private final int value;

    public ManualCount(int value) {
        this.value = value;
    }

    public static ManualCount from(String value) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException("양수만 입력 가능합니다");
        }
        return new ManualCount(Integer.parseInt(value));
    }

    private static boolean isNumber(String value) {
        return value.chars()
                .allMatch(Character::isDigit);
    }

    public int multiply(int value) {
        return this.value * value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
