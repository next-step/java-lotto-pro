package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    public void 로또번호_자동생성_후_자리수검사() {
        LottoNumbers lottoNumbers = LottoGenerator.generate();
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 로또번호_자동생성_후_중복검사() {
        LottoNumbers lottoNumbers = LottoGenerator.generate();

        assertThat(lottoNumbers.getLottoNumbers().stream()
                .distinct()
                .count()).isEqualTo(6);
    }

}