package lotto.utils;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilsTest {

    @Test
    void 로또_랜더_숫자_테스트() {
        LottoNumbers lottoNumbers = LottoUtils.generateLottoNumber();
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

}