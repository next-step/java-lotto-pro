package lotto.service;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "14900:14", "14100:14", "13900:13", "15100:15"}, delimiter = ':')
    void 구입_가능한_로또_갯수_조회(int amount, int expectedCount) {
        // given, when
        int count = lottoService.countPurchasableLotto(amount);

        // then
        assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    void 로또_일치_갯수_조회() {
        // given
        LottoNumbers winningLottoNumbers = createWinningLottoNumbers();
        LottoNumbers myLottoNumbers = createFiveWinningLottoNumbers();

        // when
        int result = lottoService.countWinningNumber(winningLottoNumbers, myLottoNumbers);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 수익률_계산() {
        // given
        int purchaseCount = 14;
        int winningAmount = 5000;

        // when
        double result = lottoService.getRateOfReturn(purchaseCount, winningAmount);

        // then
        assertThat(result).isGreaterThanOrEqualTo(0.35);
    }

    private LottoNumbers createWinningLottoNumbers() {
        List<LottoNumber> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(new LottoNumber(i));
        }
        return new LottoNumbers(list);
    }

    private LottoNumbers createFiveWinningLottoNumbers() {
        List<LottoNumber> list = new ArrayList<>();
        for (int i = 2; i < 8; i++) {
            list.add(new LottoNumber(i));
        }
        return new LottoNumbers(list);
    }
}
