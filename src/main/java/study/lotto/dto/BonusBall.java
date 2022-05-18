package study.lotto.dto;

public class BonusBall {
    private final int value;

    public BonusBall(String stringValue) {
        this.value = parseNumber(stringValue);
    }

    public int get() {
        return value;
    }

    private int parseNumber(String stringValue) {
        return Integer.parseInt(stringValue);
    }
}
