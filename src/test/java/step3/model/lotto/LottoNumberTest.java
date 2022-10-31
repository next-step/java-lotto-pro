package step3.model.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "20", "45"})
    void 정상_입력(int input) {
        LottoNumber lottoNumber = new LottoNumber(input);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(input));

    }
    @ParameterizedTest
    @ValueSource(strings = {"50", "-1", "0"})
    void 범위_외_입력_에러(int input) {
        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}