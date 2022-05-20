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

        Money money = money();
        int numberOfManual = numberOfManualLottoGames().getValue();
        LottoTicket lottoTicket = machine.sellTicket(money, manualLottoGames(numberOfManual));
        int numberOfGames = lottoTicket.numberOfGames(money);
        int numberOfAuto = numberOfGames - numberOfManual;
        ResultView.printTicket(numberOfAuto, numberOfManual, lottoTicket);

        WinningNumbers winningNumbers = winningNumbers();
        LottoNumber bonusLottoNumber = bonusLottoNumber(winningNumbers);
        LottoResult result = machine.check(
                lottoTicket,
                new LottoWin(winningNumbers, bonusLottoNumber));
        ResultView.printStats(result);
    }

    private Money money() {
        Money money = takeMoney();
        while (money == null) {
            money = takeMoney();
        }
        return money;
    }

    private Money takeMoney() {
        try {
            return new Money(InputView.readMoney());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private NumberOfGames numberOfManualLottoGames() {
        NumberOfGames number = getNumberOfManualLottoGames();
        while (number == null) {
            number = getNumberOfManualLottoGames();
        }
        return number;
    }

    private NumberOfGames getNumberOfManualLottoGames() {
        try {
            return new NumberOfGames(InputView.readNumberOfManualLottoGames());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private List<LottoGame> manualLottoGames(int numberOfGames) {
        if (numberOfGames == 0) {
            return new ArrayList<>();
        }

        List<LottoGame> manualLottoGames = getManualLottoGames(numberOfGames);
        while (manualLottoGames == null) {
            manualLottoGames = getManualLottoGames(numberOfGames);
        }
        return manualLottoGames;
    }

    private List<LottoGame> getManualLottoGames(int numberOfGames) {
        try {
            List<String> games = InputView.readManualLottoGames(numberOfGames);
            return games.stream()
                    .map(numbers -> new LottoGame(numbers))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private WinningNumbers winningNumbers() {
        WinningNumbers winningNumbers = getWinningNumbers();
        while (winningNumbers == null) {
            winningNumbers = getWinningNumbers();
        }

        return winningNumbers;
    }

    private WinningNumbers getWinningNumbers() {
        try {
            return new WinningNumbers(InputView.readWinningNumbers());
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }

    private LottoNumber bonusLottoNumber(WinningNumbers winningNumbers) {
        LottoNumber bonusLottoNumber = getBonusLottoNumber(winningNumbers);
        while (bonusLottoNumber == null) {
            bonusLottoNumber = getBonusLottoNumber(winningNumbers);
        }

        return bonusLottoNumber;
    }

    private LottoNumber getBonusLottoNumber(WinningNumbers winningNumbers) {
        try {
            return new LottoNumber(InputView.readBonusNumber(), winningNumbers);
        } catch (IllegalArgumentException e) {
            ResultView.printExceptionMessage(e.getMessage());
            return null;
        }
    }
}
