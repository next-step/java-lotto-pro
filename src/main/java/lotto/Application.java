package lotto;

import lotto.domain.*;
import lotto.ui.InputView;
import lotto.ui.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        new Application().startGame();
    }

    private void startGame() {
        int purchasePrice = InputView.getPurchasePrice();

        List<LottoTicket> selfTickets = getSelfLottoTickets(InputView.getSelfTicketCount());
        LottoGame game = new LottoGame(purchasePrice, selfTickets, new LottoNumberGenerator());
        ResultView.printTicketCount(game.getAutoTicketCount(), game.getSelfTicketCount());

        game.printTickets();
        game.generateGameResult(new WinnerTicket(InputView.getWinnerNumbers()
                , new LottoNumber(InputView.getBonusBallNumber())));

        game.printGameResult();
    }

    private List<LottoTicket> getSelfLottoTickets(int selfTicketCount) {
        List<String> selfTicketNumbers = InputView.getSelfTickets(selfTicketCount);
        List<LottoTicket> selfTickets = selfTicketNumbers.stream()
                .map(stringNumbers -> new LottoTicket(new LottoNumbers(StringParserUtils.parseNumbers(stringNumbers))))
                .collect(Collectors.toList());
        ResultView.printEmptyLine();
        return selfTickets;
    }
}
