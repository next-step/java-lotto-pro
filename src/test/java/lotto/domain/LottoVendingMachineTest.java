package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoVendingMachineTest {

    @Test
    void 자판기에서_금액을_입력하면_로또를_살_수_있다() {
        LottoVendingMachine vendingMachine = new LottoVendingMachine();
        LottoTickets tickets = vendingMachine.purchase(Money.from(10_000));
        assertThat(tickets.getCount()).isEqualTo(10);
    }
}
