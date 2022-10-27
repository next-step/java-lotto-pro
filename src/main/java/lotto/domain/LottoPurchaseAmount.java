package lotto.domain;

import java.util.Objects;

public class LottoPurchaseAmount  {
    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoPurchaseAmount(String inputAmount) {
        this.amount = parseAmount(inputAmount);
        validThousands();
        validPositive();
    }

    private int parseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

    private void validThousands() {
        if (this.amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException("1000 단위로 입력해주세요.");
        }
    }

    private void validPositive() {
        if (this.amount < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }

    public int getQuantity() {
        return this.amount / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchaseAmount that = (LottoPurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}