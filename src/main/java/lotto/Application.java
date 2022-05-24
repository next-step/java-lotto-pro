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
        ResultView.printEmptyLine();

        int selfTicketCount = InputView.getSelfTicketCount();
        ResultView.printEmptyLine();

        List<String> selfTicketNumbers = InputView.getSelfTickets(selfTicketCount);
        List<LottoTicket> selfTickets = selfTicketNumbers.stream()
                .map(stringNumbers -> new LottoTicket(new LottoNumbers(StringParserUtils.parseNumbers(stringNumbers))))
                .collect(Collectors.toList());
        ResultView.printEmptyLine();

        NumberGenerator numberGenerator = new LottoNumberGenerator();
        LottoGame game = new LottoGame(purchasePrice, selfTickets, numberGenerator);
        ResultView.printTicketCount(game.getAutoTicketCount(), game.getSelfTicketCount());

        game.printTickets();
        ResultView.printEmptyLine();

        String winnerNumbers = InputView.getWinnerNumbers();
        int bonusBallNumber = InputView.getBonusBallNumber();
        game.generateGameResult(new WinnerTicket(winnerNumbers, new LottoNumber(bonusBallNumber)));
        ResultView.printEmptyLine();

        game.printGameResult();
    }
}
