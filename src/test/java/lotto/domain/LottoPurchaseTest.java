package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {
    @Test
    @DisplayName("lotto 가격이 1000원일 때, 14개의 lotto 가 구입되어야 함")
    void test1() {
        LottoMachine machine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(machine);
        LottoBundle lottoBundle = lottoStore.buyAutoLotto(Money.of(14000));

        assertThat(lottoBundle.size()).isEqualTo(14);
    }
}