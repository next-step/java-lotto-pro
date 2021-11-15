package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoStoreTest {

    @DisplayName("로또 구매")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "10000:10", "50000:50"}, delimiter = ':')
    void lottoPurchase(int purchaseAmount, int expectLottoPurchaseNumber) {
        //given
        final Money money = new Money(purchaseAmount);
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        Lottos lottos = LottoStore.purchase(money, 1, manualLottoNumbers);

        //then
        assertThat(lottos.purchaseNumber()).isEqualTo(expectLottoPurchaseNumber);
    }

    @DisplayName("수동으로 구매할 로또 수는 로또 구입금액을 초과할 수 없다")
    @Test
    void lottoManualPurchaseCountExcessMoney() {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore.purchase(new Money(1000), 2, manualLottoNumbers);
        });
    }

    @DisplayName("수동으로 구매할 로또 수와 로또의 개수가 같아야 한다")
    @Test
    void lottoManualPurchaseCountNotMatchManualLottoCount() {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoStore.purchase(new Money(1000), 1, manualLottoNumbers);
        });
    }

    @DisplayName("수동 로또 생성")
    @Test
    void createManualLotto() {
        //given
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));
        manualLottoNumbers.add(Arrays.asList(13, 14, 15, 16, 17, 18));
        List<Lotto> manualLottos = new ArrayList<>();
        manualLottos.add(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        manualLottos.add(Stream.of(7, 8, 9, 10, 11, 12)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        manualLottos.add(Stream.of(13, 14, 15, 16, 17, 18)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));

        //when
        Lottos lottos = LottoStore.purchase(new Money(3000), 3, manualLottoNumbers);

        //then
        assertThat(lottos).isEqualTo(new Lottos(manualLottos));
    }
}
