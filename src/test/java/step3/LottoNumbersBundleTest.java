package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoRanks;
import step3.domain.WinningLotto;
import step3.domain.strategy.numbers.NumbersStrategy;

public class LottoNumbersBundleTest {

    @ParameterizedTest
    @CsvSource(value = {
        "1,2,3,4,5,6:1,2,3,4,5,6:7:2000000000", // 1등
        "1,2,3,4,5,6:1,2,3,4,5,7:6:30000000",   // 2등
        "1,2,3,4,5,6:1,2,3,4,5,7:10:1500000",   // 3등
        "1,2,3,4,5,6:1,2,3,4,8,7:6:50000",      // 4등
        "1,2,3,4,5,6:1,2,3,9,8,7:6:5000",       // 5등
    }, delimiter = ':')
    @DisplayName("등수별 총 상금 테스트")
    void lottoRanksOf_totalPrize(String buyNumbersStr, String winNumbersStr, int bonusNumber, Long expected) {
        // given
        LottoNumbers winLottoNumbers = new LottoNumbers(parseNumbers(winNumbersStr));
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);
        LottoNumbersBundle lottoNumbersBundle = new LottoNumbersBundle();
        addLottoNumbers(buyNumbersStr, lottoNumbersBundle);

        // when
        WinningLotto winningLotto = new WinningLotto(winLottoNumbers, bonusLottoNumber);
        LottoRanks lottoRanks = lottoNumbersBundle.lottoRanksOf(winningLotto);
        Long totalPrize = lottoRanks.totalPrize();

        // then
        assertThat(totalPrize).isEqualTo(expected);
    }

    private void addLottoNumbers(String buyNumbersStr, LottoNumbersBundle lottoNumbersBundle) {
        NumbersStrategy numbersStrategy = new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return parseNumbers(buyNumbersStr);
            }
        };
        lottoNumbersBundle.addLottoNumbers(numbersStrategy);
    }

    private int[] parseNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(",")).mapToInt(Integer::parseInt).toArray();
    }

}
