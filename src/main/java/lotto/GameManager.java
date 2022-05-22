package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.NumberOfGames;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResult;
import lotto.dto.LottoWin;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameManager {

    public void run() {
        LottoVendingMachine machine = new LottoVendingMachine(new LottoNumbersGeneratorKr());

        Money money = takeMoney();

        int numberOfTotalGames = money.numberOfGames(LottoVendingMachine.PRICE_PER_GAME);
        int numberOfManualGames = getNumberOfManualLottoGames(numberOfTotalGames).getValue();
        int numberOfAutoGames = numberOfTotalGames - numberOfManualGames;

        LottoTicket lottoTicket = machine.sellTicket(money, getManualLottoGames(numberOfManualGames));
        ResultView.printTicket(numberOfAutoGames, numberOfManualGames, lottoTicket);

        WinningNumbers winningNumbers = getWinningNumbers();
        LottoNumber bonusLottoNumber = getBonusLottoNumber(winningNumbers);
        LottoResult result = machine.check(
                lottoTicket,
                new LottoWin(winningNumbers, bonusLottoNumber));
        ResultView.printStats(result);
    }

    private Money takeMoney() {
        while (true) {
            try {
                Money money = new Money(InputView.readMoney(), LottoVendingMachine.PRICE_PER_GAME);
                return money;
            } catch (IllegalArgumentException e) {
                ResultView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private NumberOfGames getNumberOfManualLottoGames(int limit) {
        while (true) {
            try {
                return new NumberOfGames(InputView.readNumberOfManualLottoGames(), limit);
            } catch (IllegalArgumentException e) {
                ResultView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private List<LottoGame> getManualLottoGames(int numberOfGames) {
        if (numberOfGames == 0) {
            return new ArrayList<>();
        }

        while (true) {
            try {
                List<String> games = InputView.readManualLottoGames(numberOfGames);
                return games.stream()
                        .map(numbers -> new LottoGame(numbers))
                        .collect(Collectors.toList());
            } catch (IllegalArgumentException e) {
                ResultView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private WinningNumbers getWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(InputView.readWinningNumbers());
            } catch (IllegalArgumentException e) {
                ResultView.printExceptionMessage(e.getMessage());
                return null;
            }
        }
    }

    private LottoNumber getBonusLottoNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                return new LottoNumber(InputView.readBonusNumber(), winningNumbers);
            } catch (IllegalArgumentException e) {
                ResultView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
