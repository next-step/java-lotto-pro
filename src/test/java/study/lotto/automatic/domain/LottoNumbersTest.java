package study.lotto.automatic.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {
    @Test
    @DisplayName("로또번호가 6개면 생성가능하다.")
    void 유효한_로또번호() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers lottoNumber = new LottoNumbers(numbers);
        assertThat(lottoNumber).isNotNull();
    }

    @Test
    @DisplayName("로또번호가 6개가 아니면 IllegalArgumentException 를 발생시킨다.")
    void 무효한_로또번호() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }
}
