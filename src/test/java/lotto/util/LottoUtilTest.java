package lotto.util;

import static org.junit.jupiter.api.Assertions.*;

import lotto.model.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoUtilTest {

    @Test
    @DisplayName("금액에 따라 구매 가능한 로또 개수를 구한다,")
    void 금액에_따른_구매가능한_로또_개수를_구한다() {
        assertEquals(LottoUtil.calculatePossiblePurchaseLottoCount(new Money(14000)), 14);
    }

}
