package lotto.controller;

import lotto.domain.LottoFactory;
import lotto.domain.LottoHelper;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoControllerTest {

    LottoController lottoController = new LottoController();

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "14900:14", "14100:14", "13900:13", "15100:15"}, delimiter = ':')
    void 구입_가능한_로또_갯수_조회(int amount, int expectedCount) {
        // given, when
        int count = lottoController.countPurchasableLotto(amount);

        // then
        assertThat(count).isEqualTo(expectedCount);
    }

    @Test
    void 구입_가능한_로또_갯수_조회_금액_미달() {
        // given
        int amount = LottoHelper.LOTTO_PER_PRICE - 10;

        // when, then
        assertThatThrownBy(() -> lottoController.countPurchasableLotto(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_일치_갯수_조회() {
        // given
        LottoNumbers winningLottoNumbers = createWinningLottoNumbers();
        LottoNumbers myLottoNumbers = createFiveWinningLottoNumbers();

        // when
        int result = lottoController.countWinningNumber(winningLottoNumbers, myLottoNumbers);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 로또_일치_갯수_조회_로또_번호_빈값() {
        // given
        LottoNumbers winningLottoNumbers = createWinningLottoNumbers();
        LottoNumbers myLottoNumbers = createFiveWinningLottoNumbers();

        // when, then
        assertThatThrownBy(() -> lottoController.countWinningNumber(null, myLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoController.countWinningNumber(winningLottoNumbers, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_일치_갯수_조회_로또_번호_갯수_불일치() {
        // given
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        LottoNumbers winningLottoNumbers = new LottoNumbers(lottoNumbers);
        LottoNumbers myLottoNumbers = new LottoNumbers(lottoNumbers);

        // when, then
        assertThatThrownBy(() -> lottoController.countWinningNumber(winningLottoNumbers, myLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산() {
        // given
        int purchaseCount = 14;
        int winningAmount = 5000;

        // when
        double result = lottoController.getRateOfReturn(purchaseCount, winningAmount);

        // then
        assertThat(result).isGreaterThanOrEqualTo(0.35);
    }

    @Test
    void 수익률_계산_구입_갯수_부족() {
        // given
        int purchaseCount = 0;
        int winningAmount = 5000;

        // when
        assertThatThrownBy(() -> lottoController.getRateOfReturn(purchaseCount, winningAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산_당첨_금액_음수() {
        // given
        int purchaseCount = 5;
        int winningAmount = -5000;

        // when
        assertThatThrownBy(() -> lottoController.getRateOfReturn(purchaseCount, winningAmount))
                .isInstanceOf(IllegalArgumentException.class);
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