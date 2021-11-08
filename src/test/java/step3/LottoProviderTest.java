package step3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import step3.domain.Amount;
import step3.domain.LottoProvider;
import step3.domain.strategy.numbers.RandomLottoNumbers;

public class LottoProviderTest {

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "5500:5"}, delimiter = ':')
    @DisplayName("지불 금액에 해당하는 구입가능 최대로 로또 구입")
    void buyLottoOfAmount(int amount, int expected) {
        // given

        // when
        LottoProvider lottoProvider = new LottoProvider();
        lottoProvider.buyLotto(lottoProvider.availableQuantity(new Amount(amount)), new RandomLottoNumbers());

        // then
        assertThat(lottoProvider.lottoNumbersBundleSize()).isEqualTo(expected);
    }

}
