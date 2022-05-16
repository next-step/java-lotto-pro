package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRandomNumbersTest {

    @Test
    void 로또_번호_생성시_사이즈_검증() {
        // given
        LottoRandomNumbers lottoRandomNumbers = new LottoRandomNumbers();

        // when
        List<LottoNumber> lottoNumbers = lottoRandomNumbers.generate();

        // then
        assertThat(lottoNumbers).size().isEqualTo(6);
    }
}
