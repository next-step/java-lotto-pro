package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 숫자 테스트")
class LottoNumbersTest {

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void lotto_number_generated() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.numbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 번호 중복 오류 확인")
    @Test
    void lotto_number_duplicate_error() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또는 6개의 숫자로 이루어져야 한다.")
    @Test
    void lotto_number_range_error() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또번호를 비교하여 같은 번호의 리스트를 반환한다.")
    void same_number_return() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8));
        assertThat(lottoNumbers1.match(lottoNumbers2)).containsExactlyInAnyOrderElementsOf(Arrays.asList(3, 4, 5, 6));
    }
}