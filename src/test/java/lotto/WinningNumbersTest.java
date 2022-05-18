package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            new WinningNumbers("1,1,1,2,2,3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 6})
    void 번호_일치(int input) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        boolean result = winningNumbers.has(new LottoNumber(input));

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 10, 20, 45})
    void 번호_불일치(int input) {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        boolean result = winningNumbers.has(new LottoNumber(input));

        assertThat(result).isFalse();
    }

}
