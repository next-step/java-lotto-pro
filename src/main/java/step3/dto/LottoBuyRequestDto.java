package step3.dto;

import step3.domain.Amount;

public class LottoBuyRequestDto {
    private final Amount amount;

    public LottoBuyRequestDto(int amount) {
        this.amount = new Amount(amount);
    }

    public Amount getAmount() {
        return amount;
    }

    public int getAmountValue() {
        return amount.getAmount();
    }
}
