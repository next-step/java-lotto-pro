package lotto.domain;

import lotto.consts.PriceConst;
import lotto.consts.WinningEnum;
import lotto.exception.WrongPriceException;

public class Price {

    private final int price;

    public Price(int price) {
        validationCheck(price);
        this.price = price;
    }

    private void validationCheck(int price) {
        if (price < PriceConst.LOTTO_PRICE) {
            throw new WrongPriceException();
        }
    }

    public int getNumberOfLotto() {
        return price / PriceConst.LOTTO_PRICE;
    }

    public ProfitRate getProfitRate(WinningStats winningStats) {
        int totalPrize = 0;
        for (WinningEnum winningEnum : WinningEnum.values()) {
            totalPrize += getPrize(winningEnum, winningStats);
        }

        return new ProfitRate(Math.floor((double) totalPrize / price * 100) / 100.0);
    }

    private int getPrize(WinningEnum winningEnum, WinningStats winningStats) {
        if (winningEnum == WinningEnum.NONE) {
            return 0;
        }
        return winningStats.getWinningStats().get(winningEnum) * winningEnum.getPrize();
    }
}
