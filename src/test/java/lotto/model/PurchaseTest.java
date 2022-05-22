package lotto.model;

import lotto.generator.AutoLottoNumbersGenerator;
import lotto.generator.LottoNumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseTest {

    @Test
    @DisplayName("구매금액을 받아 로또 구매개수를 셋팅한다.")
    void createPurchase_구매내역() {
        Purchase purchase = Purchase.createPurchase(3000);

        assertThat(purchase.getPurchaseAmount())
                .isExactlyInstanceOf(Money.class)
                .isEqualTo(Money.of(3000));
        assertThat(purchase.getCount())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("구매금액 만큼 로또 리스트를 생성한다.")
    void createLottos_로또_리스트() {
        Purchase purchase = Purchase.createPurchase(3000);
        LottoNumbersGenerator lottoNumbersGenerator = new AutoLottoNumbersGenerator();

        Lottos lottos = purchase.createLottos(lottoNumbersGenerator);
        assertThat(lottos)
                .isNotNull();
        assertThat(lottos.lottosCount())
                .isEqualTo(3);
    }

}
