package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCountTest {

    @Test
    @DisplayName("equals 테스트")
    void equals() {
        Assertions.assertThat(LottoCount.of(0, 0)).isEqualTo(LottoCount.of(0, 0));
    }

    @Test
    @DisplayName("전체 구입할 수 있는 수량이 음수일 때 IllegalArgumentException을 던진다.")
    void purchasableQuantityException1() {
        Assertions.assertThatThrownBy(() -> LottoCount.of(-1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} | {displayName} | 전체 구입할 로또 수 : 10, 수동 : {0}")
    @ValueSource(ints = {-1, 11})
    @DisplayName("수동으로 구매할 수 있는 값이 0 ~ 전체 구입할 수 있는 수 이외의 값이면 IllegalArgumentException을 던진다.")
    void purchasableQuantityException2(int input) {
        Assertions.assertThatThrownBy(() -> LottoCount.of(10, input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} | {displayName} | 전체 구입할 로또 수 : 10, 수동 : {0}, 자동 {1}")
    @CsvSource(value = {"0:10", "5:5", "10:0"}, delimiter = ':')
    @DisplayName("수동으로 구매할 로또 갯수에 따라 자동으로 구입할 수 있는 로또 갯수 확인")
    void auto(int input, int expected) {
        LottoCount lottoCount = LottoCount.of(10, input);
        Assertions.assertThat(lottoCount.getAuto()).isEqualTo(expected);
    }
}
