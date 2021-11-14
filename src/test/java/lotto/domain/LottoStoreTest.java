package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @DisplayName("로또 구매")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "10000:10", "50000:50"}, delimiter = ':')
    void lottoPurchase(int purchaseAmount, int expectLottoPurchaseNumber) {
        //given
        final Money money = new Money(purchaseAmount);
        final LottoManual lottoManual = new LottoManual(1, money);
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1,2,3,4,5,6));
        lottoManual.createLottos(manualLottoNumbers);

        //when
        Lottos lottos = LottoStore.purchase(money, lottoManual);

        //then
        assertThat(lottos.purchaseNumber()).isEqualTo(expectLottoPurchaseNumber);
    }
}
