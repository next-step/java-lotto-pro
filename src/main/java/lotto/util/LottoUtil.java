package lotto.util;

import static lotto.constant.LottoSetting.LOTTO_UNIT_PRICE;

import lotto.model.money.Money;

public class LottoUtil {

    private LottoUtil() {
    }

    public static int calculatePossiblePurchaseLottoCount(Money purchasedMoney) {
        return purchasedMoney.getMoney() / LOTTO_UNIT_PRICE;
    }

    public static String[] splitInputWinningNumber(String inputWinningNumber) {
        return inputWinningNumber.replace(" ", "").split(",");
    }

}
