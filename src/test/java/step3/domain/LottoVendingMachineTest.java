package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {
    private final LottoVendingMachine vendingMachine;

    {
        NumberGenerateStrategy numberGenerateStrategy = new RandomNumberGenerateStrategy();
        Money lottoPrice = new Money(1000L);
        vendingMachine = new LottoVendingMachine(numberGenerateStrategy, lottoPrice);
    }

    @Test
    void 보유한_금액만큼_로또를_자동으로_구매할_수_있다() {
        Money paidByUser = new Money(5500L);
        Lottos generatedLottos = vendingMachine.buy(paidByUser);
        assertThat(generatedLottos.getHasLottoSize()).isEqualTo(5);
    }

    @Test
    void 보유한_금액만큼_로또를_수동으로_구매할_수_있다() {
        Money paidByUser = new Money(2500L);
        List<String> manualLottoNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "2, 3, 4, 5, 6, 7");
        Lottos generatedLottos = vendingMachine.buy(paidByUser, manualLottoNumbers);
        assertThat(generatedLottos.getHasLottoSize()).isEqualTo(2);
    }

    @Test
    void 구매하려는_로또의_총_가격을_알_수_있다() {
        int purchaseCount = 3;
        assertThat(vendingMachine.calculateTotalPrice(purchaseCount)).isEqualTo(new Money(3000L));
    }
}
