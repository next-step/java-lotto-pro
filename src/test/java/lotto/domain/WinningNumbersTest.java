package lotto.domain;

import static lotto.LottoTestUtils.lottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import lotto.LottoTestUtils;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    void 당첨번호_생성_테스트() {
        // given

        // when
        final WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7));

        // then
        assertThat(winningNumbers).isEqualTo(LottoTestUtils.winningNumbers(1, 2, 3, 4, 5, 6, 7));
    }
}