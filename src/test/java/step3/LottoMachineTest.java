package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.domain.Ticket;
import step3.enums.LottoReward;
import step3.model.LottoMachine;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:true", "1,2,3,4,5:false", "a,b,c,d,e,f:false"}, delimiter = ':')
    public void makeManualLottoTicketTest(String manualLottoSource, boolean expected) {
        assertThat(lottoMachine.makeManualLottoTicket(manualLottoSource) != null).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "10000:10"}, delimiter = ':')
    public void makeRandomTicketsTest(String money, int expected) {
        Ticket ticket = new Ticket(new Money(money));
        assertThat(lottoMachine.makeRandomLottoTickets(ticket)).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "40:true", "3:false", "-a:false", "-1:false"}, delimiter = ':')
    public void setBonusTest(String bonusElement, boolean expected) {
        lottoMachine.setWinnerLotto("3,4,5,6,7,8");
        assertThat(lottoMachine.setBonusNumber(bonusElement)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:true", "-a:false", "1,2,3,4,5:false", "-1,2,3,4,5,6:false"}, delimiter = ':')
    public void setWinnerLottoTest(String winnerSource, boolean expected) {
        assertThat(lottoMachine.setWinnerLotto(winnerSource)).isEqualTo(expected);
    }

    @Test
    @DisplayName("각 로또별 매칭 갯수를 HashMap으로 반환한다")
    public void checkWinTest() {
        lottoMachine.setWinnerLotto("1,2,3,4,5,6");
        lottoMachine.setBonusNumber("7");
        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); //6
        lottoTickets.add(new LottoTicket("1,2,3,4,5,8")); //5
        lottoTickets.add(new LottoTicket("1,2,11,12,13,14")); //MISS
        lottoTickets.add(new LottoTicket("1,2,3,4,7,8")); //5_bonus
        lottoTickets.add(new LottoTicket("11,12,13,14,15,16")); // MISS
        assertThat(lottoMachine.checkWin(lottoTickets)).containsEntry(LottoReward.MISS, 2).containsEntry(LottoReward.FIVE_BONUS, 1)
            .containsEntry(LottoReward.FIVE, 1).containsEntry(LottoReward.SIX, 1);
    }
}


