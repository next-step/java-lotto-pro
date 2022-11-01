package lotto.dto;

import lotto.domain.LottoMoney;

public class LottoMoneyRequestDto {

    private LottoMoney lottoMoney;

    public LottoMoneyRequestDto(String money) {
        this.lottoMoney = new LottoMoney(money);
    }

    public LottoMoney getLottoMoney() {
        return lottoMoney;
    }

}
