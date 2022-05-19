package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.LottoReward;
import step3.model.LottoMachine;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        lottoMachine = new LottoMachine();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:false", "1,2,3,4,5:true", "a,b,c,d,e,f:true"}, delimiter = ':')
    public void setWinnerTicket(String manualLottoSource, boolean isThrowable) {
        if (isThrowable) {
            assertThatThrownBy(() -> lottoMachine.setWinnerLotto(manualLottoSource)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setWinnerLotto(manualLottoSource));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "10000:10"}, delimiter = ':')
    public void makeRandomTicketsTest(String money, int expected) {
        int ticket = lottoMachine.getLottoTicketCount(new Money(money));
        assertThat(lottoMachine.makeRandomLottoTickets(ticket)).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "40:false", "3:true", "-a:true", "-1:true"}, delimiter = ':')
    public void setBonusTest(String bonusElement, boolean isThrowable) {
        lottoMachine.setWinnerLotto("3,4,5,6,7,8");
        if (isThrowable) {
            assertThatThrownBy(() -> lottoMachine.setBonusNumber(bonusElement)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setBonusNumber(bonusElement));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:false", "-a:true", "1,2,3,4,5:true", "-1,2,3,4,5,6:true"}, delimiter = ':')
    public void setWinnerLottoTest(String winnerSource, boolean isThrowable) {
        if (isThrowable) {
            assertThatThrownBy(() -> lottoMachine.setWinnerLotto(winnerSource)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setWinnerLotto(winnerSource));
        }
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
        lottoTickets.add(new LottoTicket("1,2,3,4,7,5")); //5_bonus
        lottoTickets.add(new LottoTicket("11,12,13,14,15,16")); // MISS
        assertThat(lottoMachine.checkWin(lottoTickets)).containsEntry(LottoReward.MISS, 2).containsEntry(LottoReward.FIVE_BONUS, 1)
            .containsEntry(LottoReward.FIVE, 1).containsEntry(LottoReward.SIX, 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1002:1", "13333:13"}, delimiter = ':')
    public void getLottoTicketCountTest(String money, int expect) {
        assertThat(lottoMachine.getLottoTicketCount(new Money(money))).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1000", "3:3000", "4:4000", "11:11000"}, delimiter = ':')
    public void getUsingMoneyByTicketTest(int ticket, int expect) {
        assertThat(lottoMachine.getUsingMoneyByTicket(ticket)).isEqualTo(expect);
    }
}


