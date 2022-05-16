package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.common.LottoQuantity;
import lotto.domain.common.ManualLottoQuantity;
import lotto.domain.common.TotalLottoQuantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {

    @Test
    void 자판기에서_로또를_살_수_있다() {
        LottoVendingMachine vendingMachine = new LottoVendingMachine();

        List<LottoNumbers> manualLottoNumbersList = new ArrayList<>();
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(4, 5, 6, 7, 8, 9)));
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(7, 8, 9, 10, 11, 12)));

        LottoQuantity lottoQuantity = LottoQuantity.of(
                TotalLottoQuantity.from(5),
                ManualLottoQuantity.from(3)
        );

        Assertions.assertThat(
                        vendingMachine.purchase(lottoQuantity, manualLottoNumbersList).purchasedTicketsCount()
                )
                .isEqualTo(5);
    }
}
