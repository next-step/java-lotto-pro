package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    //TODO : 질문 2
    @DisplayName("로또 구매")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 50000})
    void lottoPurchase(int purchaseAmount) {
        Lottos lottos = LottoStore.purchase(purchaseAmount);
    }
}
