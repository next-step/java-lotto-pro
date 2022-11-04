package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("equals메소드 검증")
    void equal_test() {
        assertThat(LottoNumber.of(1).equals(LottoNumber.of(1)))
                .isTrue();
    }

    @Test
    @DisplayName("compareTo 동작 확인")
    void compareTo_test() {
        assertThat(LottoNumber.of(1).compareTo(LottoNumber.of(2)) < 0)
                .isTrue();
        assertThat(LottoNumber.of(1).compareTo(2) < 0)
                .isTrue();
        assertThat(LottoNumber.of(3).compareTo(LottoNumber.of(2)) > 0)
                .isTrue();
        assertThat(LottoNumber.of(3).compareTo(2) > 0)
                .isTrue();
        assertThat(LottoNumber.of(1).compareTo(LottoNumber.of(1)))
                .isEqualTo(0);
    }

    @Test
    @DisplayName("dto 값 확인")
    void dto_value_test() {
        assertThat(LottoNumber.of(1).getLottoNumberDto())
                .isEqualTo(1);
    }
}
