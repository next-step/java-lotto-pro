package lotto_auto.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class PurchaseInfoTest {
    private Money money;

    @BeforeEach
    void setup() {
        money = new Money("5000");
    }

    @Test
    void 금액대비_로또수_초과() {
        LottoCount lottoCount = new LottoCount("50");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseInfo(money, lottoCount))
                .withMessage(PurchaseInfo.NOT_ENOUGH_MONEY);
    }

    @Test
    void 자동_로또수_매치() {
        PurchaseInfo info = new PurchaseInfo(money, new LottoCount("2"));
        assertThat(info.getAutoLottoCount()).isEqualTo(3);
    }

    @Test
    void 수동_로또수_매치() {
        PurchaseInfo info = new PurchaseInfo(money, new LottoCount("2"));
        assertThat(info.getManualLottoCount()).isEqualTo(2);
    }
}
