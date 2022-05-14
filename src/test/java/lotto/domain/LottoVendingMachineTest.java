package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {

    @Test
    void 자판기에서_금액을_입력하면_로또를_살_수_있다() {
        LottoVendingMachine vendingMachine = new LottoVendingMachine();
        assertAll(
                ()-> assertEquals(vendingMachine.purchase(Money.from(10_000)).purchasedTicketsCount(), 10),
                ()-> assertEquals(vendingMachine.purchase(Money.from(15_000)).purchasedTicketsCount(), 15),
                ()-> assertEquals(vendingMachine.purchase(Money.from(10_500)).purchasedTicketsCount(), 10),
                ()-> assertEquals(vendingMachine.purchase(Money.from(17_700)).purchasedTicketsCount(), 17)
        );
    }
}
