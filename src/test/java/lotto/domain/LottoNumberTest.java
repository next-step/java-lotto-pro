package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
    @Test
    @DisplayName("주어진 숫자로 LottoNumber가 생성된다")
    void create_with_number() {
        LottoNumber lottoNumber = new LottoNumber(2);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(2));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    @DisplayName("범위 밖의 숫자로 생성시 오류를 반환한다")
    void create_fail_with_number_that_out_of_range(int number) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(number);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
