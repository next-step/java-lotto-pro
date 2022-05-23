package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.LottoReward;
import step3.model.LottoGenerator;
import step3.model.LottoMachine;
import step3.model.LottoTickets;
import step3.model.LottoWinChecker;

public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        lottoMachine = new LottoMachine(new LottoGenerator(), new LottoWinChecker());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:false", "1,2,3,4,5:true", "a,b,c,d,e,f:true"}, delimiter = ':')
    public void setWinnerTicket(String manualLottoSource, boolean isThrowable) {
        if (isThrowable) {
            assertThatThrownBy(
                () -> lottoMachine.setWinnerLottoTicket(manualLottoSource)).isInstanceOf(
                IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setWinnerLottoTicket(manualLottoSource));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "10000:10"}, delimiter = ':')
    public void makeRandomTicketsTest(String money, int expected) {
        int ticket = lottoMachine.getLottoTicketCount(new Money(money));
        assertThat(lottoMachine.makeRandomLottoTickets(ticket)).hasSize(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "40:false", "3:true", "-a:true",
        "-1:true"}, delimiter = ':')
    public void setBonusTest(String bonusElement, boolean isThrowable) {
        lottoMachine.setWinnerLottoTicket("3,4,5,6,7,8");
        if (isThrowable) {
            assertThatThrownBy(() -> lottoMachine.setBonusNumber(bonusElement)).isInstanceOf(
                IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setBonusNumber(bonusElement));
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:false", "-a:true", "1,2,3,4,5:true",
        "-1,2,3,4,5,6:true"}, delimiter = ':')
    public void setWinnerLottoTest(String winnerSource, boolean isThrowable) {
        if (isThrowable) {
            assertThatThrownBy(() -> lottoMachine.setWinnerLottoTicket(winnerSource)).isInstanceOf(
                IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> lottoMachine.setWinnerLottoTicket(winnerSource));
        }
    }

    @Test
    @DisplayName("각 로또별 매칭 갯수를 HashMap으로 반환한다")
    public void checkWinTest() {
        lottoMachine.setWinnerLottoTicket("1,2,3,4,5,6");
        lottoMachine.setBonusNumber("7");
        List<LottoTicket> lottoTickets = new ArrayList<>();

        lottoTickets.add(new LottoTicket("1,2,3,4,5,6")); //6
        lottoTickets.add(new LottoTicket("1,2,3,4,5,8")); //5
        lottoTickets.add(new LottoTicket("1,2,11,12,13,14")); //MISS
        lottoTickets.add(new LottoTicket("1,2,3,4,7,5")); //5_bonus
        lottoTickets.add(new LottoTicket("11,12,13,14,15,16")); // MISS
        assertThat(lottoMachine.checkWin(lottoTickets)).containsEntry(LottoReward.MISS, 2)
            .containsEntry(LottoReward.FIVE_BONUS, 1)
            .containsEntry(LottoReward.FIVE, 1).containsEntry(LottoReward.SIX, 1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1002:1", "13333:13"}, delimiter = ':')
    public void getLottoTicketCountTest(String money, int expect) {
        assertThat(lottoMachine.getLottoTicketCount(new Money(money))).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:true", "2:1:false", "3:1:false", "2:2:false"}, delimiter = ':')
    public void validateManualLottoCountTest(int ticket, int manualLottoCount,
        boolean isThrowable) {
        if (isThrowable) {
            assertThatThrownBy(
                () -> lottoMachine.validateManualLottoCount(ticket, manualLottoCount)).isInstanceOf(
                IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(
                () -> lottoMachine.validateManualLottoCount(ticket, manualLottoCount));
        }
    }

    @Test
    @DisplayName("정상적인 수동 로또 생성")
    public void makeManualLottoTicketOK() {
        List<String> manualLottoTicketSources = new ArrayList();
        manualLottoTicketSources.add("1,2,3,4,5,6");
        manualLottoTicketSources.add("2,3,4,5,6,7");
        manualLottoTicketSources.add("4,5,6,7,8,9");

        assertThat(lottoMachine.makeManualLottoTickets(manualLottoTicketSources))
            .hasSize(3);
    }

    @Test
    @DisplayName("비정상적 수동 로또 생성")
    public void makeManualLottoTicketThrow() {
        List<String> manualLottoTicketSources = new ArrayList();
        manualLottoTicketSources.add("a,2,3,4,5,6");
        manualLottoTicketSources.add("2,3,5,6,7");
        manualLottoTicketSources.add("4,5,6,7,,8");
        manualLottoTicketSources.add("4,5,6,7,,46");

        assertThatThrownBy(
            () -> lottoMachine.makeManualLottoTickets(manualLottoTicketSources)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @Test
    public void checkMatchLottoResultTest() {
        initMachine();
        LottoTickets userLottoTickets = createUserLottoTickets();
        Map<LottoReward, Integer> matchCountPerLottoReward = lottoMachine.checkWin(
            userLottoTickets.getLottoTickets());
        Map<String, String> lottoResult = lottoMachine.checkMatchLottoResult(
            matchCountPerLottoReward, 4);
        long reward = 30_000_000 + 50_000 + 5_000 + 2_000_000_000;

        assertThat(lottoResult)
            .containsEntry("isBenefit", "이득")
            .containsEntry("profitRate", String.valueOf(reward * 1.0 / (1000 * 4)))
            .containsEntry("reward", String.valueOf(reward));
    }

    private void initMachine() {
        lottoMachine.setWinnerLottoTicket("1,2,3,4,5,6");
        lottoMachine.setBonusNumber("7");

    }

    private LottoTickets createUserLottoTickets() {
        ArrayList<LottoTicket> lottoTicketsArray = new ArrayList<>();
        lottoTicketsArray.add(new LottoTicket("1,2,3,4,5,7")); //5_b
        lottoTicketsArray.add(new LottoTicket("1,2,3,4,10,8"));//4
        lottoTicketsArray.add(new LottoTicket("1,2,3,11,12,13"));//3
        lottoTicketsArray.add(new LottoTicket("1,2,3,4,5,6"));//6
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.addLottoTickets(lottoTicketsArray);
        return lottoTickets;
    }
}


