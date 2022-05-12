package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PayTest {
    @ParameterizedTest(name = "구입가능개수 반환 ({0} : {1})")
    @CsvSource(value = {"1000:1", "5000:5", "100:0"}, delimiter = ':')
    void ableToBuyLottoCount(int money, int expected) {
        assertThat(Pay.ableToBuyLottoCount(money)).isEqualTo(expected);
    }
}