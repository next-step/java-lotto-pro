package lotto;

import lotto.model.LottoQuantityChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("LottoQuantityChecker는 ")
public class LottoQuantityCheckerTest {
    @DisplayName("금액에 따른 로또 수량을 계산한다")
    @Test
    void validCheck() {
        String price = "14000";
        assertThat(LottoQuantityChecker.calculate(price)).isEqualTo(14);
    }

    @DisplayName("1000원 단위가 아니라면 예외를 던진다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "100"})
    void invalidCheck(String price) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoQuantityChecker.calculate(price));
    }
}
