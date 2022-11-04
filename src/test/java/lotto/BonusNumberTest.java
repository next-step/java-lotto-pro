package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스번호 정상생성 테스트")
    void name() {
        assertThat((BonusNumber.of("3")).equals(BonusNumber.of("3"))).isTrue();
    }

    @ParameterizedTest
    @DisplayName("보너스번호 유효성 체크")
    @ValueSource(strings = {"aa","-10","46","0"})
    void buyAmount_invalidate_test(String input) {
        assertThatThrownBy(() -> BonusNumber.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
