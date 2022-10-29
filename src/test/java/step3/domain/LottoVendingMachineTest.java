package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {
    private final LottoVendingMachine vendingMachine = new LottoVendingMachine(new RandomNumberGenerateStrategy());

    @Test
    void 보유한_금액만큼_로또를_구매할_수_있다() {
        Money paidByUser = new Money(5500L);
        Lottos generatedLottos = vendingMachine.buy(paidByUser);
        assertThat(generatedLottos.getHasLottoSize()).isEqualTo(5);
    }
}
