package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    void 전달된_숫자가_포함되는지_검사() {
        // given
        LottoNumbers lottoNumbers = LottoFactory.createLottoNumbers();
        LottoNumber lottoNumber1 = new LottoNumber(lottoNumbers.getLottoNumbers().get(0).getNumber());
        LottoNumber lottoNumber2 = new LottoNumber(0);

        // when
        boolean result1 = lottoNumbers.containsNumber(lottoNumber1);
        boolean result2 = lottoNumbers.containsNumber(lottoNumber2);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

}