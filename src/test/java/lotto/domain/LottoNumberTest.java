package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("범위에서 벗어난 LottoNumber 예외 처리")
    void lottoNumber_out_of_range_test() {
        assertThatThrownBy(() -> new LottoNumber("140")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("두 LottoNumber 일치 여부 테스트")
    void LottoNumber_equals_test() {
        assertThat(new LottoNumber(1).equals(new LottoNumber(1))).isTrue();
    }

    @Test
    @DisplayName("두 LottoNumber 크기 비교 테스트")
    void compare_LottoNumbers_test() {
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(2))).isEqualTo(-1);
        assertThat(new LottoNumber(1).compareTo(new LottoNumber(1))).isEqualTo(0);
        assertThat(new LottoNumber(2).compareTo(new LottoNumber(1))).isEqualTo(1);
    }

}
