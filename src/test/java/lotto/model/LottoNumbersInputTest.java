package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersInputTest {

    @ParameterizedTest
    @DisplayName("로또 번호 입력 비정상 값 검증")
    @ValueSource(strings = {"1, 2, 2, 3, 4, 5", "a, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5"})
    public void checkNotValid(String text) {
        assertThatThrownBy(() -> { new LottoNumbersInput(text);}).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 입력 값과 동일한지 검증")
    public void checkSameOriginValue() {
        assertThat(new LottoNumbersInput("1, 2, 3, 4, 5, 6").value()).isEqualTo("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("로또 번호 입력 값이 배열로 변환되는지 검증")
    public void checkToArray() {
        assertThat(new LottoNumbersInput("1, 2, 3, 4, 5, 6")
                .toArray()).isEqualTo(new String[]{"1", "2", "3", "4", "5", "6"});
    }
}
