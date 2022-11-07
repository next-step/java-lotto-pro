package lotto.dto;

import lotto.domain.BuyAmount;
import lotto.domain.BuyCountLotto;

public class BuyCountLottoDto {

    private int directBuyCount;
    private BuyAmount buyAmount;
    private BuyCountLotto buyCountLotto;

    public BuyCountLottoDto(int directBuyCount, BuyAmount buyAmount, BuyCountLotto buyCountLotto) {
        this.directBuyCount = directBuyCount;
        this.buyAmount = buyAmount;
        this.buyCountLotto = buyCountLotto;
    }

    public int getDirectBuyCount() {
        return directBuyCount;
    }

    public BuyAmount getBuyAmount() {
        return buyAmount;
    }

    public BuyCountLotto getBuyCountLotto() {
        return buyCountLotto;
    }
}
