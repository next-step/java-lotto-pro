package lotto.service;

import lotto.config.LottoGameConfig;
import lotto.domain.LottoWinner;
import lotto.domain.LottosResult;
import lotto.domain.LottosWinnerCounts;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMoneyServiceTest {

    LottoMoneyService lottoMoneyService = new LottoMoneyService();

    @DisplayName("calculatePurchasingCount 예상한 갯수만큼 구매 가능한지 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {
            "0,0",
            "500,0",
            "1000,1",
            "1500,1",
            "2000,2"})
    void calculatePurchasingCountTest01(int money, int expectedCount) {
        int result = lottoMoneyService.calculatePurchasingCount(money);
        assertThat(result)
                .isEqualTo(expectedCount);
    }

    @DisplayName("음수의 값을 입력했을 때 구매할 수 없다는 exception이 발생하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1})
    void calculatePurchasingCountTest02(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = lottoMoneyService.calculatePurchasingCount(money);
        });
    }

    @DisplayName("5개 구입해서 4등이 한번 된 경우에 LottosResult 가 제대로 만들어지는지 확인 ")
    @Test
    void makeLottosResultTest01() {
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        lottosWinnerCounts.reflectResult(LottoWinner.FORTH);

        LottosResult lottosResult = lottoMoneyService.makeLottosResult(5, lottosWinnerCounts);
        assertThat(lottosResult.ratio())
                .isEqualTo(1.0f);
    }

    @DisplayName("4개 구입해서 1,2,3,4 등이 각각 한번씩 된 경우에 LottosResult 가 제대로 만들어지는지 확인 ")
    @Test
    void makeLottosResultTest02() {
        int count = 4;
        LottosWinnerCounts lottosWinnerCounts = new LottosWinnerCounts();
        lottosWinnerCounts.reflectResult(LottoWinner.FIRST);
        lottosWinnerCounts.reflectResult(LottoWinner.SECOND);
        lottosWinnerCounts.reflectResult(LottoWinner.THIRD);
        lottosWinnerCounts.reflectResult(LottoWinner.FORTH);

        float expectedRatio = (LottoWinner.FIRST.getWinnerMoney() +
                LottoWinner.SECOND.getWinnerMoney() +
                LottoWinner.THIRD.getWinnerMoney() +
                LottoWinner.FORTH.getWinnerMoney()) / (float) (count * LottoGameConfig.PURCHASE_MONEY);

        LottosResult lottosResult = lottoMoneyService.makeLottosResult(count, lottosWinnerCounts);
        assertThat(lottosResult.ratio())
                .isEqualTo(expectedRatio);
    }
}