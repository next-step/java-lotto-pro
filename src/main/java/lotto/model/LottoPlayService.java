package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.vo.Lottos;

public class LottoPlayService {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_MAX_PURCHASE_PRICE = 10_000_000;


    public Lottos convertMoneyToLottos(int money) {
        validateMoney(money);

        int playCount = money / LOTTO_PRICE;
        return new Lottos(playCount);
    }

    private void validateMoney(int money) {
        validateLackMoney(money);
        validateOverMoney(money);
    }

    private void validateLackMoney(int money) {
        if(money < LOTTO_PRICE){
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY);
        }
    }

    private void validateOverMoney(int money) {
        if(money >= LOTTO_MAX_PURCHASE_PRICE){
            throw new IllegalArgumentException(ErrorMessage.OVER_MONEY);
        }
    }

}
