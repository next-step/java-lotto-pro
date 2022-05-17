package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.common.Messages.BONUS_BALL_NOT_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class BonusBallTest {

    @ParameterizedTest
    @ValueSource(strings = {"7"})
    void 보너스볼_정상_입력(String string) {
        BonusBall bonusBall = new BonusBall(string);
        assertThat(bonusBall.toString()).isEqualTo("7");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc"})
    void 보너스볼_영문_입력(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusBall(string))
                .withMessageContaining(BONUS_BALL_NOT_NUMBER);
    }
}
