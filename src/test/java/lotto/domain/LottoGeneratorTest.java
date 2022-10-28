package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @DisplayName("로또 랜덤 숫자 사이즈 확인하기")
    @Test
    void check_lotto_random_number_size() {
        LottoNumbers lottoNumbers = LottoGenerator.generateLottoNumber();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}