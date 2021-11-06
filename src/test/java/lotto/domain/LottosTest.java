package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

    @DisplayName("로또를 여러장 구매하는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "15000:15", "1000:1", "500:0", "7500:7" }, delimiter = ':')
    public void 로또구매_확인(int money, int expected) {
        assertThat(new Lottos(new Money(money)).getLottos().size()).isEqualTo(expected);
    }

}
