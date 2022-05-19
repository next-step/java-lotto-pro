package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottosManual;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottosManual 클래스")
public class LottosManualTest {
    @DisplayName("수동 로또번호가 숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,a,3,4,5,6,7", "1,2,3,b,5,6,7", "1,2,3,4,5,c,7"})
    void isNotNumberThenThrowsIllegalArgumentException(final String manualLottoString) {
        final List<String> manualLottosString = Arrays.asList(manualLottoString);
        assertThatThrownBy(() -> new LottosManual(manualLottosString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또번호 개수가 7개가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7,8", "1,2,3,4,5,6", "1,2,3,4,5,6,7,8,9"})
    void sizeIsNotSevenThenThrowsIllegalArgumentException(final String manualLottoString) {
        final List<String> manualLottosString = Arrays.asList(manualLottoString);
        assertThatThrownBy(() -> new LottosManual(manualLottosString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또번호가 1이상 45이하의 숫자가 아니면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,2,3,4,5,6,7", "1,2,3,4,5,46,47", "1,2,3,4,5,6,99"})
    void isNotRangeOneToFourtyFiveThenThrowsIllegalArgumentException(final String manualLottoString) {
        final List<String> manualLottosString = Arrays.asList(manualLottoString);
        assertThatThrownBy(() -> new LottosManual(manualLottosString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 로또번호가 중복이 존재하면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,3,4,5,6,7", "1,2,2,3,4,5,6", "1,2,4,4,5,6,7"})
    void cannotBeDuplicated(final String manualLottoString) {
        final List<String> manualLottosString = Arrays.asList(manualLottoString);
        assertThatThrownBy(() -> new LottosManual(manualLottosString))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
