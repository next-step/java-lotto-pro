package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("당첨 로또 번호 null 이거나 비어있을 경우 Exception 발생 확인")
    void validateNullOrEmpty(String input) {
        assertThatThrownBy(() -> {
            new LottoNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 1", "3, 3, 3, 4, 5, 6"})
    @DisplayName("당첨 로또 번호 중에 중복되는 번호가 존재할 경우 Exception 발생 확인")
    void validateUnique(String input) {
        assertThatThrownBy(() -> {
            new LottoNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1, 2", "1, 2, 3"})
    @DisplayName("당첨 로또 번호가 6개가 아닐 경우 Exception 발생 확인")
    void validateSize(String input) {
        assertThatThrownBy(() -> {
            new LottoNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    @DisplayName("당첨 로또 번호 중에 범위 내(1-45) 에 있지 않은 번호가 존재할 경우 Exception 발생 확인")
    void validateRange(String input) {
        assertThatThrownBy(() -> {
            new LottoNumbers(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
