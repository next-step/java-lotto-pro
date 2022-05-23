package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.LottoReward;

public class LottoMachine {
    private final LottoGenerator lottoGenerator;
    private final LottoWinChecker lottoWinChecker;
    private final LottoWinInfoResearcher lottoWinInfoResearcher;
    private static final int LOTTO_PRICE = 1_000;
    private static final int EMPTY = 0;

    private static final String CANT_BUY_LOTTO_EXCEPTION_MSG =
        "돈은 최소 " + LOTTO_PRICE + "이상 입력해야합니다";
    private static final String MANUAL_LOTTO_COUNT_OVER_TICKET_EXCEPTION_MSG = "입금한 돈을 초과할수 없습니다.";

    public LottoMachine(LottoGenerator lottoGenerator, LottoWinChecker lottoWinChecker,
        LottoWinInfoResearcher lottoWinInfoResearcher) {
        this.lottoGenerator = lottoGenerator;
        this.lottoWinChecker = lottoWinChecker;
        this.lottoWinInfoResearcher = lottoWinInfoResearcher;
    }

    public List<LottoTicket> makeRandomLottoTickets(int randomTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < randomTicketCount; i++) {
            lottoTickets.add(lottoGenerator.makeRandomLottoTicket());
        }
        return lottoTickets;
    }

    public List<LottoTicket> makeManualLottoTickets(List<String> manualLottoTicketsSource) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String manualLottoTicketElements : manualLottoTicketsSource) {
            lottoTickets.add(lottoGenerator.makeManualLottoTicket(manualLottoTicketElements));
        }
        return lottoTickets;
    }

    public void setWinnerLottoTicket(String winnerLottoTicketElements) {
        LottoTicket winnerTicket = lottoGenerator.makeManualLottoTicket(winnerLottoTicketElements);
        lottoWinChecker.setWinnerLottoTicket(winnerTicket);
    }

    public void setBonusNumber(String lottoNumberElement) {
        lottoWinChecker.setBonusNumber(lottoNumberElement);
    }

    public int getLottoTicketCount(Money money) {
        int ticketCount = money.getMoney() / LottoMachine.LOTTO_PRICE;
        if (ticketCount == LottoMachine.EMPTY) {
            throw new IllegalArgumentException(LottoMachine.CANT_BUY_LOTTO_EXCEPTION_MSG);
        }
        return ticketCount;
    }

    public Map<LottoReward, Integer> checkWin(List<LottoTicket> userLottoTickets) {
        return lottoWinChecker.checkWin(userLottoTickets);
    }

    public void validateManualLottoCount(int ticketCount, int manualLottoCount) {
        if (ticketCount < manualLottoCount) {
            throw new IllegalArgumentException(
                LottoMachine.MANUAL_LOTTO_COUNT_OVER_TICKET_EXCEPTION_MSG);
        }
    }

    public Map<String, String> checkMatchLottoResult(Map<LottoReward, Integer> checkWinResult,
        int ticketCount) {
        return lottoWinInfoResearcher.checkMatchLottoResult(checkWinResult, ticketCount);
    }

}
