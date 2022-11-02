package step3.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.LottoNumber;
import step3.domain.lotto.LottoNumbers;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static step3.domain.lotto.LottoNumbers.DEFAULT_LOTTO_SIZE;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 생성 전략 - 랜덤")
    void lottoRandomGenerate() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Random());
        assertThat(lottoNumbers.value()).hasSize(DEFAULT_LOTTO_SIZE);
    }

    @Test
    @DisplayName("로또 생성 전략 - 수동")
    void lottoManualGenerate() {
        LottoNumbers lottoNumbers = new LottoNumbers(new Manual(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lottoNumbers.value()).containsExactly(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );
    }
}
