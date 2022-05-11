package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.vo.Lottos;

public class LottoPlayService {

    private static final int LOTTO_PRICE = 1000;

    public Lottos convertMoneyToLottos(int money) {
        validateLackMoney(money);
        int playCount = money / LOTTO_PRICE;
        return new Lottos(playCount);
    }

    private void validateLackMoney(int money) {
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY);
        }
    }
}
