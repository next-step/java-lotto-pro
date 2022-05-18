package lotto.service;

import lotto.config.LottoGameConfig;
import lotto.domain.LottoWinner;
import lotto.domain.LottosResult;
import lotto.domain.LottosWinnerCounts;

public class LottoMoneyService {
    public int calculatePurchasingCount(int money) {
        validateMoney(money);
        return money / LottoGameConfig.PURCHASE_MONEY;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("money는 음수일 수 없습니다.");
        }
    }

    public LottosResult makeLottosResult(int purchasingCount, LottosWinnerCounts lottosWinnerCounts) {
        LottosResult lottosResult = new LottosResult(purchasingCount * LottoGameConfig.PURCHASE_MONEY);
        for (LottoWinner winner : LottoWinner.values()) {
            int count = lottosWinnerCounts.winnerCount(winner);
            long winnerMoney = winner.getWinnerMoney() * count;
            lottosResult.plusReturnMoney(winnerMoney);
        }
        return lottosResult;
    }
}
