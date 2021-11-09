package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("판매한 로또 개수 테스트")
    @ParameterizedTest(name = "{displayName}{index} -> amount: {0}, expected: {1}")
    @CsvSource(value = {"1000:1", "1500:1", "2000:2"}, delimiter = ':')
    void sell(int amount, int expected) {
        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);
        List<Lotto> lottoList = lottoMachine.sell(purchaseAmount);

        // then
        Assertions.assertThat(lottoList).hasSize(expected);
    }
}
