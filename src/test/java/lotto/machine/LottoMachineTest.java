package lotto.machine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.ticket.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    private static int LOTTO_AMOUNT = 1_000;
    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp(){
        lottoMachine = new LottoMachine();
    }

    @Test
    void 로또_구매시_금액이_모자란경우_exception_발생(){
        assertThatThrownBy(() -> lottoMachine.getQuantity(1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_구매_금액_일치한경우_수량_반환(int ticketCount){
        int result = lottoMachine.getQuantity(ticketCount * LOTTO_AMOUNT);
        assertThat(result).isEqualTo(ticketCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1_001, 1_999})
    void 로또_구매_금액_잔액이_남을경우_구매가능한_수량_반환(int money){
        int result = lottoMachine.getQuantity(money);
        assertThat(result).isEqualTo(money / LOTTO_AMOUNT);
    }

    @Test
    void 로또_1장을_구매한다(){
        LottoTickets lottoTickets = lottoMachine.buyLotto(1_000);
        assertThat(lottoTickets.getQuantity()).isEqualTo(1);
    }

}
