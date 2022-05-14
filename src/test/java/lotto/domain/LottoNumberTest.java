package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 숫자 생성시 0초과 46미만의 수가 생성 되는지 확인")
    @Test
    void lottoNumber() {
        LottoNumber result = new LottoNumber();
        assertThat(result.getNumber()).isGreaterThan(0).isLessThan(46);
    }

    @DisplayName("로또 숫자 지정 생성시 해당 숫자를 가진 로또 숫자 객체가 생성되는지 확인")
    @Test
    void lottoNumberWithNumber() {
        LottoNumber result = new LottoNumber(5);
        assertThat(result.getNumber()).isEqualTo(5);
    }

    @DisplayName("범위를 벗어난 로또 숫자 지정시 Exception 발생 확인")
    @Test
    void lottoNumberWithExceedNumber() {
        assertThatThrownBy(() -> new LottoNumber(50)).isInstanceOf(IllegalArgumentException.class);
    }
}