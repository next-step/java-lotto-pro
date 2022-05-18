package lotto.domain;

public class LottoQuantity {
    private int quantity;

    public LottoQuantity(int input) {
        this(String.valueOf(input));
    }

    public LottoQuantity(String input) {
        try {
            quantity = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 수량입니다.");
        }

        if (isInvalidQuantity(quantity)) {
            throw new IllegalArgumentException("유효하지 않은 수량입니다.");
        }
    }

    private boolean isInvalidQuantity(int quantity) {
        return quantity < 0;
    }

    public int getQuantity() {
        return quantity;
    }
}
