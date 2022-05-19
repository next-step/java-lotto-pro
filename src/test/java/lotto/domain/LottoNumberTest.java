package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {
    @Test
    @DisplayName("숫자가 아닌 문자가 입력될 경우 오류가 발생한다.")
    void checkExceptionWithString() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumber("a")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoNumber("#")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoNumber("!")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("0이하 혹은 46이상의 숫자가 입력될 경우 오류가 발생한다.")
    void checkExceptionWithZero() {
        assertAll(
            () -> assertThatThrownBy(() -> new LottoNumber("-3")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoNumber("0")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoNumber("46")).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new LottoNumber("100")).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1~45 사이의 숫자가 입력될 경우 정상적으로 값이 생성된다.")
    void checkValid() {
        assertAll(
            () -> assertThat(new LottoNumber("1").getLottoNumber()).isEqualTo(1),
            () -> assertThat(new LottoNumber("20").getLottoNumber()).isEqualTo(20),
            () -> assertThat(new LottoNumber("39").getLottoNumber()).isEqualTo(39),
            () -> assertThat(new LottoNumber("45").getLottoNumber()).isEqualTo(45)
        );
    }
}
