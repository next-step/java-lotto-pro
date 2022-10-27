package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPurchaseTest {
    @Test
    @DisplayName("lotto 가격이 1000원일 때, 14개의 lotto 가 구입되어야 함")
    void test1() {
        Money money = Money.of(14000);
        LottoMachine machine = new LottoMachine();
        LottoStore lottoStore = new LottoStore(machine, Money.of(1000));
        LottoBundle lottoBundle = lottoStore.buyLotto(money);

        assertThat(lottoBundle.size()).isEqualTo(14);
    }
}