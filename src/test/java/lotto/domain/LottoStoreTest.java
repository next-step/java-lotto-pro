package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"2500,2", "1500,1"}, delimiter = ',')
    void test(int inputMoney, int tryCount) {
        Money money = new Money(inputMoney);

        LottoGame game = LottoStore.sell(money);

        assertThat(game.getTryCount()).isEqualTo(tryCount);
    }

}