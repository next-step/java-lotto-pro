package lotto.model;

import lotto.vo.Lottos;

public class LottoPlayService {

    private static final int LOTTO_PRICE = 1000;

    public Lottos convertMoneyToLottos(int money) {
        int playCount = money / LOTTO_PRICE;
        return new Lottos(playCount);
    }
}
