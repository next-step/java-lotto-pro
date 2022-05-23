package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.LottoTicket;
import step3.enums.LottoReward;
import step3.model.LottoGenerator;
import step3.model.LottoMachine;
import step3.model.LottoTickets;
import step3.model.LottoWinChecker;
import step3.model.LottoWinInfoResearcher;


public class LottoWinInfoResearcherTest {

    private LottoWinInfoResearcher lottoWinInfoResearcher;
    private LottoMachine lottoMachine;


    @BeforeEach
    public void init(){
        lottoWinInfoResearcher = new LottoWinInfoResearcher();
        lottoMachine = new LottoMachine(
            new LottoGenerator(),
            new LottoWinChecker(),
            new LottoWinInfoResearcher());
    }
    @Test
    public void checkMatchLottoResultTest() {
        initMachine();
        LottoTickets userLottoTickets = createUserLottoTickets();
        Map<LottoReward, Integer> matchCountPerLottoReward = lottoMachine.checkWin(
            userLottoTickets.getLottoTickets());
        Map<String, String> lottoResult = lottoWinInfoResearcher.getLottoRewardStatistics(
            matchCountPerLottoReward, 4);


        long reward = 30_000_000 + 50_000 + 5_000 + 2_000_000_000;

        assertThat(lottoResult)
            .containsEntry("isBenefit", "이득")
            .containsEntry("profitRate", String.valueOf(reward * 1.0 / (1000 * 4)));
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
