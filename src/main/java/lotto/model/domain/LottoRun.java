package lotto.model.domain;

import lotto.model.constants.LottoConstants;
import lotto.model.vo.Lotto;
import lotto.model.vo.PurchaseCount;

public class LottoRun {
    public static PurchaseCount getPurchaseCount(long buyAmount) {
        return new PurchaseCount(buyAmount/LottoConstants.LOTTO_UNIT_PRICE);
    }

    public static int countMatchNumber(Lotto winLotto, Lotto userLotto) {
        return 0;
    }

    public static double calculateProfit(long buyAmount, long winAmount) {
        return 0;
    }
}
