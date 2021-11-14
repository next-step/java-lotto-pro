package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoManualTest {

    @DisplayName("수동으로 구매할 로또 수는 로또 구입금액을 초과할 수 없다")
    @Test
    void lottoManualPurchaseCountExcessMoney() {
        final int lottoManualPurchaseCount = 2;
        final Money money = new Money(1000);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoManual(lottoManualPurchaseCount, money);
        });
    }

    @DisplayName("수동으로 구매할 로또 수와 로또의 개수가 같아야 한다")
    @Test
    void lottoManualPurchaseCountNotMatchManualLottoCount() {
        final LottoManual lottoManual = new LottoManual(3, new Money(4000));
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoManual.createLottos(manualLottoNumbers);
        });
    }

    @DisplayName("수동 로또 생성")
    @Test
    void createManualLotto() {
        //given
        final LottoManual lottoManual = new LottoManual(3, new Money(4000));
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        manualLottoNumbers.add(Arrays.asList(7, 8, 9, 10, 11, 12));
        manualLottoNumbers.add(Arrays.asList(13, 14, 15, 16, 17, 18));
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        lottos.add(Stream.of(7, 8, 9, 10, 11, 12)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));
        lottos.add(Stream.of(13, 14, 15, 16, 17, 18)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)));

        //when
        final LottoManual manualLottos = lottoManual.createLottos(manualLottoNumbers);

        //then
        assertThat(manualLottos.getManualLotto()).isEqualTo(lottos);
    }
}
