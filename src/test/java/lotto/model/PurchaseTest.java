package lotto.model;

import lotto.generator.AutoLottoNumbersGenerator;
import lotto.generator.LottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @Test
    @DisplayName("구매금액과 수동 구매개수를 입력받아 로또 구매내역을 셋팅한다.")
    void createPurchase_구매내역() {
        Purchase purchase = Purchase.createPurchase(5000, 2);

        assertThat(purchase.getPurchaseAmount())
                .isExactlyInstanceOf(Money.class)
                .isEqualTo(Money.of(5000));
        assertThat(purchase.getManualCount())
                .isEqualTo(2);
        assertThat(purchase.getAutoCount())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("구매개수 만큼 로또 리스트를 생성한다.")
    void createLottos_로또_리스트() {
        Purchase purchase = Purchase.createPurchase(5000, 2);
        int autoCount = purchase.getAutoCount();
        LottoNumbersGenerator lottoNumbersGenerator = new AutoLottoNumbersGenerator();

        Lottos lottos = purchase.createLottos(lottoNumbersGenerator, autoCount);
        assertThat(lottos)
                .isNotNull();
        assertThat(lottos.lottosCount())
                .isEqualTo(autoCount);
    }

}
