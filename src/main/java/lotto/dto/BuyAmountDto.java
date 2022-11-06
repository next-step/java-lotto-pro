package lotto.dto;

import lotto.domain.BuyAmount;

public class BuyAmountDto {

    private int buyAmount;
    private BuyAmount buyAmountDomain;

    public BuyAmountDto(int buyAmount, BuyAmount buyAmountDomain) {
        this.buyAmount = buyAmount;
        this.buyAmountDomain = buyAmountDomain;
    }

    public BuyAmount getBuyAmountDomain() {
        return buyAmountDomain;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

}
