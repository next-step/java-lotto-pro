package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.LottoProvider;
import step3.domain.LottoRanks;
import step3.domain.constance.LottoConstant;
import step3.domain.strategy.lotto.LottoProviderStrategy;
import step3.domain.strategy.numbers.NumbersStrategy;
import step3.domain.strategy.numbers.RandomNumbers;

public class LottoProviderTest {

    @Test
    @DisplayName("buyLotto 메소드 인자만큼 LottoNumbers 생성하는지 테스트")
    void lottoProviderBuyLotto() {
        // given
        int expected = 5;

        // when
        LottoProviderStrategy lottoProvider = new LottoProvider();
        lottoProvider.buyLotto(expected);

        // then
        assertThat(lottoProvider.lottoNumbersBundleSize()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "5500:5"}, delimiter = ':')
    @DisplayName("지불 금액에 해당하는 구입가능 최대로 로또 구입")
    void buyLottoOfAmount(int amount, int expected) {
        // given

        // when
        LottoProviderStrategy lottoProvider = new LottoProvider();
        lottoProvider.buyLotto(lottoProvider.availableQuantity(amount));

        // then
        assertThat(lottoProvider.lottoNumbersBundleSize()).isEqualTo(expected);
    }

    @Test
    void 당첨금액합산구하기() {
        // given
        // 3개 구매
        // 4등 2개 당첨
        LottoProviderStrategy lottoProvider = new LottoProvider();

        // 당첨 금액 만원

        List<int[]> numbers = new ArrayList<>();
        int[] winNumbers = {10, 20, 3, 4, 5, 6};
        numbers.add(new int[] {1, 2, 3, 4, 5, 6});
        numbers.add(new int[] {1, 2, 3, 4, 5, 6});
        numbers.add(randomNumberStrategy().getNumbers());

        for (int[] numberArr : numbers) {
            lottoProvider.buyLottoOfNumbersStrategy(generateNumberStrategy(numberArr));
        }

        // when
        NumbersStrategy winnerLottoNumbers = generateNumberStrategy(winNumbers);
        LottoNumbers winLottoNumbers = new LottoNumbers(winnerLottoNumbers);
        LottoNumbersBundle lottoNumbersBundle = lottoProvider.getLottoNumbersBundle();

        LottoRanks lottoRanks = lottoNumbersBundle.lottoRanksOf(winLottoNumbers);
        System.out.println(lottoRanks);

        // then
    }

    private NumbersStrategy generateNumberStrategy(int[] numbers) {
        return new NumbersStrategy() {
            @Override
            public int[] getNumbers() {
                return numbers;
            }
        };
    }

    private NumbersStrategy randomNumberStrategy() {
        return new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE, LottoConstant.MAX_NUMBER_RANGE,
            LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }

}
