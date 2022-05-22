package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    LottoMachine lottoMachine;

    @BeforeEach
    void init() {
        lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14500:14", "24300:24"}, delimiter = ':')
    @DisplayName("입력 갯수만큼 로또 티켓이 생성되는지 확인")
    void size(int purchaseMoney, int expected) {
        Money money = new Money(purchaseMoney);
        LottoMachine lottoMachine = new LottoMachine();
        LottoTickets lottoTickets = lottoMachine.buyLottoTicket(money);
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14500:14", "24300:24"}, delimiter = ':')
    @DisplayName("수동 로또 생성 시 입력 수만큼 로또 티켓이 생성되는지 확인")
    void sizeWithManual(int purchaseMoney, int expected) {
        Money money = new Money(purchaseMoney);
        List<LottoTicket> manualTicketList = new ArrayList<>();
        manualTicketList.add(new LottoTicket("1, 2, 3, 4, 5, 6"));
        LottoTickets lottoTickets = lottoMachine.buyLottoTicketWithManual(money, new LottoTickets(manualTicketList));
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }
}
