package study.lotto;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    @DisplayName("로또넘버 생성")
    void createLottoNumber() {
        assertThatCode(() -> new LottoNumber(5))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또넘버 생성 - 문자열")
    void createLottoNumber_string() {
        assertThatCode(() -> new LottoNumber("5"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("로또넘버 생성 - 범위 미만의 수")
    void createLottoNumber_minException() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또넘버 생성 - 범위 초과한 수")
    void createLottoNumber_maxException() {
        Assertions.assertThatThrownBy(() -> new LottoNumber(66)).isInstanceOf(IllegalArgumentException.class);
    }
}