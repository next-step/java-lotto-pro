package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("로또 숫자 지정 생성시 해당 숫자를 가진 로또 숫자 객체가 생성되는지 확인")
    @Test
    void lottoNumberWithNumber() {
        LottoNumber result = new LottoNumber(5);
        assertThat(result.getNumber()).isEqualTo(5);
    }

    @DisplayName("같은 숫자를 가진 로또 숫자 객체가 equal 로 판단되는지 확인")
    @Test
    void lottoNumberWithSameNumber() {
        LottoNumber result = new LottoNumber(5);
        assertThat(result).isEqualTo(new LottoNumber(5));
    }

    @DisplayName("같은 숫자를 가진 로또 숫자 객체가 같은 hashCode를 갖는지 확인")
    @Test
    void lottoNumberWithSameHashCode() {
        LottoNumber result = new LottoNumber(5);
        assertThat(result.hashCode()).isEqualTo(new LottoNumber(5).hashCode());
    }

    @DisplayName("범위를 벗어난 로또 숫자 지정시 Exception 발생 확인")
    @Test
    void lottoNumberWithExceedNumber() {
        assertThatThrownBy(() -> new LottoNumber(50)).isInstanceOf(IllegalArgumentException.class);
    }

}