package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void lotto_number_generated() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_중복_오류() {
        // TODO: 로또 번호 중복이면 오류
    }

    @DisplayName("로또는 6개의 숫자로 이루어져야 한다.")
    @Test
    void 로또_번호_범위_오류() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}