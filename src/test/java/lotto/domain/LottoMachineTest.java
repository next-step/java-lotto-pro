package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14500:14", "24300:24"}, delimiter = ':')
    @DisplayName("입력 갯수만큼 로또 티켓이 생성되는지 확인")
    void size(int purchaseMoney, int expected) {
        Money money = new Money(purchaseMoney);
        LottoMachine lottoMachine = new LottoMachine();
        LottoTickets lottoTickets = lottoMachine.buyLottoTicket(money);
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }
}
