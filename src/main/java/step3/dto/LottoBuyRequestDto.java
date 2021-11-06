package step3.dto;

import step3.domain.Amount;
import step3.domain.LottoNumbersBundle;

public class LottoBuyRequestDto {
    private Amount amount;

    public void mapAmount(int amount) {
        this.amount = new Amount(amount);
    }

    public Amount getAmount() {
        return amount;
    }

    public int getAmountValue() {
        return amount.getAmount();
    }
}
