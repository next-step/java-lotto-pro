package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoNumberTest {

    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(5);
        assertThat(lottoNumber)
                .usingRecursiveComparison()
                .isEqualTo(new LottoNumber(5));
    }

    @DisplayName("1~45 이외의 숫자를 입력했을 경우")
    @Test
    void createLottoNumber_범위_초과() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
