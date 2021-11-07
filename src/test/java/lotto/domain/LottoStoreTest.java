package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("로또 구매")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "50000:50"}, delimiter = ':')
    void lottoPurchase(int purchaseAmount, int expectLottoPurchaseNumber) {
        Lottos lottos = LottoStore.purchase(purchaseAmount);

        int lottoPurchaseNumber = lottos.purchaseNumber();

        assertThat(lottoPurchaseNumber).isEqualTo(expectLottoPurchaseNumber);
    }
}
