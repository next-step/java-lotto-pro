package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    public void 로또번호_자동생성_후_자리수검사() {
        List<Integer> lottoNumbers = LottoGenerator.generate();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    public void 로또번호_자동생성_후_중복검사() {
        List<Integer> lottoNumbers = LottoGenerator.generate();

        assertThat(lottoNumbers.stream()
                .distinct()
                .count()).isEqualTo(6);
    }
}