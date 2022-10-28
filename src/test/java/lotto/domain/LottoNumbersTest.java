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
        // TODO: 이부분 테스트 코드 수정 필요
        List<LottoNumber> lottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_중복_오류() {
        // TODO: 로또 번호 중복이면 오류
    }

    @DisplayName("로또는 6개의 숫자로 이루어져야 한다.")
    @Test
    void 로또_번호_범위_오류() {
        // TODO: 이부분 테스트 코드 수정 필요
        List<LottoNumber> small = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5));
        List<LottoNumber> big = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7));
        assertThatThrownBy(() -> new LottoNumbers(small))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumbers(big))
                .isInstanceOf(IllegalArgumentException.class);
    }
}