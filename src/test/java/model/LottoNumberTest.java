package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("지정된 범위의 로또값을 정상적으로 생성하는 테스트")
    void lotto_number_generate_test() {
        LottoNumber lottoNumber = new LottoNumber(45);

        assertThat(lottoNumber).isEqualTo(new LottoNumber(45));
    }

    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @DisplayName("지정된 범위의 로또숫자가 아닐 경우 예외를 발생시키는 테스트")
    @ValueSource(ints = { 46, -1, 0, 100 })
    void amount_valid_check_test(int number) {
        assertThatThrownBy(() -> new LottoNumber(number))
                .isInstanceOf(RuntimeException.class);
    }
}