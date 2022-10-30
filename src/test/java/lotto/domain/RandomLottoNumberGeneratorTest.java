package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RandomLottoNumberGeneratorTest {

    @Test
    void 생성된_각각의_숫자는_1_이상() {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        assertThat(lottoNumberGenerator.generateLottoNumbers()).allMatch(lottoNumber -> lottoNumber.compareTo(LottoNumber.from(1)) >= 0);
    }

    @Test
    void 생성된_각각의_숫자는_45_이하() {
        LottoNumberGenerator lottoNumberGenerator = new RandomLottoNumberGenerator();
        assertThat(lottoNumberGenerator.generateLottoNumbers()).allMatch(lottoNumber -> lottoNumber.compareTo(LottoNumber.from(45)) <= 0);
    }
}
