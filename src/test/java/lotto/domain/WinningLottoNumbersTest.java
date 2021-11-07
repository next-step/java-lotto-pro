package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoNumbersTest {
    @DisplayName("객체 동등성 비교")
    @Test
    void testEquals() {
        LottoNumbers winningNumbers = LottoNumbers.of("1,2,3,4,5,6");
        LottoNumber bonusNumber = new LottoNumber(7);
        assertThat(new WinningLottoNumbers(winningNumbers, bonusNumber)).isEqualTo(new WinningLottoNumbers(winningNumbers, bonusNumber));
        assertThat(new WinningLottoNumbers(winningNumbers)).isEqualTo(new WinningLottoNumbers(winningNumbers));
    }

    @DisplayName("주어진 번호와 당첨번호가 일치하는 자리수에 따라 당첨순위를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,7,8,45:FOURTH", "1,2,3,4,8,45:THIRD", "1,2,3,4,5,9:SECOND", "1,2,3,4,5,6:FIRST"}, delimiter = ':')
    void testGetRank(String text, Rank expectedRank) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(LottoNumbers.of("1,2,3,4,5,6"));
        LottoNumbers lottoNumbers = LottoNumbers.of(text);
        Rank rank = winningLottoNumbers.getRank(lottoNumbers);
        assertThat(rank).isEqualTo(expectedRank);
    }
}
