package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,33,45,12,2,6"})
    void 정상_생성_Trim_체크(String input) {
        Lotto lotto = new Lotto(input);
        assertThat(lotto).isEqualTo(new Lotto(input));
    }

    @Test
    void 정상_생성_프린트_검증() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }


    @ParameterizedTest
    @NullAndEmptySource
    void 빈_입력(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 3, 4,5,6", "1,1,1,1,1,1"})
    void 중복된_입력(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4", "1"})
    void 잘못된_로또_사이즈(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 0, 4, 7,8", "1, a, b, c,#,%"})
    void 잘못된_입력_LottoNumberInvalid(String input) {
        assertThatThrownBy(() -> new Lotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}