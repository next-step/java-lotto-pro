package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Amount;
import step3.domain.LottoNumbers;
import step3.domain.LottoProvider;
import step3.domain.constance.LottoConstant;
import step3.domain.numbers.NumbersStrategy;
import step3.domain.numbers.RandomNumbers;

public class LottoProviderTest {

    @Test
    @DisplayName("buyLotto 메소드 인자만큼 LottoNumbers 생성하는지 테스트")
    void lottoProviderBuyLotto() {
        // given
        int expected = 5;

        // when
        LottoProvider lottoProvider = new LottoProvider();
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
        LottoProvider lottoProvider = new LottoProvider();
        lottoProvider.buyLotto(new Amount(amount));

        // then
        assertThat(lottoProvider.lottoNumbersBundleSize()).isEqualTo(expected);
    }

    private NumbersStrategy generateNumberStrategy() {
        return new RandomNumbers(LottoConstant.MIN_NUMBER_RANGE, LottoConstant.MAX_NUMBER_RANGE,
            LottoNumbers.MAX_LOTTO_NUMBERS_SIZE);
    }

}
