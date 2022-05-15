package lotto.auto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.auto.type.LottoGeneratorType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchasedLottoTest {

    @Test
    @DisplayName("로또가 자동일 경우 상태값이 AUTO인지 체크")
    void 자동일_경우_상태값_체크() {
        PurchasedLotto purchasedLotto = PurchasedLotto.createAuto();
        assertEquals(purchasedLotto.getLottoGeneratorType(), LottoGeneratorType.AUTO);
    }

}
