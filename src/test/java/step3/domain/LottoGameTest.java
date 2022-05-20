package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoGameTest {
    @ParameterizedTest(name = "입력된 금액에 따른 구입가능한 자동로또 개수를 반환한다. ({0} : {1})")
    @CsvSource(value = {"2000:1", "5000:4", "100:0"}, delimiter = ':')
    void 구입가능한_자동로또_개수_반환(int money, int expected) {
        assertThat(LottoGame.autoLottoCount(new Money(money), 1)).isEqualTo(expected);
    }
}
