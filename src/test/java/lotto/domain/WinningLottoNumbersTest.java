package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoNumbersTest {
    @DisplayName("객체 동등성 비교")
    @Test
    void testEquals() {
        LottoNumbers winningNumbers = LottoNumbers.of("1,2,3,4,5,6");
        LottoNumber bonusNumber = LottoNumber.of(7);
        assertThat(new WinningLottoNumbers(winningNumbers, bonusNumber)).isEqualTo(new WinningLottoNumbers(winningNumbers, bonusNumber));
        assertThat(new WinningLottoNumbers(winningNumbers)).isEqualTo(new WinningLottoNumbers(winningNumbers));
    }

    @DisplayName("당첨번호 6개와 중복되는 보너스 번호를 입력하면 오류가 발생한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,6:1"}, delimiter = ':')
    void testNotDuplicate(String text, String bonusNumber) {
        assertThatThrownBy(() -> new WinningLottoNumbers(LottoNumbers.of(text), LottoNumber.of(bonusNumber)))
                .isInstanceOf(IllegalArgumentException.class);
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

    @DisplayName("주어진 번호와 당첨번호가 일치하는 자리수에 따라 당첨순위를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,7,8,45:45:FOURTH", "1,2,3,4,5,45:45:SECOND_WITH_BONUS"}, delimiter = ':')
    void testGetRankWithBonus(String text, int bonusNumber, Rank expectedRank) {
        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(LottoNumbers.of("1,2,3,4,5,6"), LottoNumber.of(bonusNumber));
        LottoNumbers lottoNumbers = LottoNumbers.of(text);
        Rank rank = winningLottoNumbers.getRank(lottoNumbers);
        assertThat(rank).isEqualTo(expectedRank);
    }
}
