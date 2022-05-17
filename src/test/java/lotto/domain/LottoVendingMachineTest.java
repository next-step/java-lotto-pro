package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {

    @Test
    void 자판기에서_로또를_살_수_있다() {
        LottoVendingMachine vendingMachine = new LottoVendingMachine();

        List<LottoNumbers> manualLottoNumbersList = new ArrayList<>();
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(4, 5, 6, 7, 8, 9)));
        manualLottoNumbersList.add(LottoNumbers.from(Arrays.asList(7, 8, 9, 10, 11, 12)));

        Money inputMoney = Money.from(5000);

        InputLottoInformation inputLottoInformation = InputLottoInformation.of(inputMoney, manualLottoNumbersList);
        assertThat(
                        vendingMachine.purchase(inputLottoInformation).purchasedTicketsCount()
                )
                .isEqualTo(5);
    }
}
