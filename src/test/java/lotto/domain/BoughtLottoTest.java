package lotto.domain;

import lotto.exception.InvalidMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoughtLottoTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1000,1", "50000,50"
    })
    @DisplayName("구입한 로또 개수")
    public void buyToLottoTest(int money, int count) {
        BoughtLotto boughtLotto = new BoughtLotto(money);

        int boughtCount = boughtLotto.getBoughtCount();

        assertThat(boughtCount).isEqualTo(count);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0, 999, 1001, -1
    })
    @DisplayName("구입한 로또 개수 - 실패")
    public void buyToLottoTest_fail(int money) {
        assertThatThrownBy(() -> new BoughtLotto(money))
                .isInstanceOf(InvalidMoneyException.class);

    }

}