package study.lotto.domain.lottomachine;

public class LottoCount {
    private final int value;

    public LottoCount(String stringValue) {
        value = validate(stringValue);
    }

    private int validate(String price) {
        int parsedValue = parseNumber(price);
        if (parsedValue < 0) {
            throw new IllegalArgumentException("로또 수는 0보다 크거나 같아야 합니다.");
        }
        return parsedValue;
    }

    private int parseNumber(String priceString) {
        return Integer.parseInt(priceString);
    }
}
