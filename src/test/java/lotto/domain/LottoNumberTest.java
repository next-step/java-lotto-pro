package lotto.domain;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("6개의 번호로 발급되는지 확인한다.")
    void 테스트_로또번호6개_발급() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.lottoNumberCount()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호를 오름차순 정렬한다.")
    void 테스트_로또번호_오름차순() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(1, 3, 5, 4, 2, 6));
        assertThat(lottoNumber.equals(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 번호와 당첨 번호를 확인한다.")
    void 테스트_로또번호_당첨번호_확인() {
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(5, 8, 9, 10, 11, 12));
        int result = lottoNumber.winningCount(Arrays.asList(7, 8, 9, 10, 11, 12));
        assertThat(result).isEqualTo(5);
    }
}
