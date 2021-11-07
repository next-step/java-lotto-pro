package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;

import java.util.Arrays;

public class LottoController {

    private final LottoCalculator lottoCalculator;

    public LottoController() {
        this.lottoCalculator = new LottoCalculator(ConsoleIn.inputPurchaseAmount());
        printLottos();
    }

    public void run() {
        lottoCalculator.calculate(ConsoleIn.inputWinNumber(), ConsoleIn.inputBonusNumber());
        WinningResults winningResults = lottoCalculator.getWinningResults();

        printHeader();
        printWinningResults(winningResults);
        printProceedsRate(winningResults);
    }

    private void printLottos() {
        ConsoleOut.printMessage(Message.LOTTOS_PRINT.getMessage(), lottoCalculator.getLottosSize());
        for (Lotto lotto : lottoCalculator.getLottos().getLottos()) {
            ConsoleOut.printMessage(lotto.toString());
        }
        ConsoleOut.newLine();
    }

    private void printHeader() {
        ConsoleOut.newLine();
        ConsoleOut.printMessage(Message.WIN_RESULT_HEADER.getMessage());
        ConsoleOut.printMessage(Message.BAR_PRINT.getMessage());
    }

    private void printWinningResults(WinningResults winningResults) {
        Arrays.stream(WinningResult.values())
                .filter(winningResult -> winningResult != WinningResult.NOT_MATCHED)
                .forEach(winningResult -> printWinningResult(winningResult, winningResults.getCount(winningResult)));
    }

    private void printProceedsRate(WinningResults winningResults) {
        long proceeds = winningResults.getProceeds();
        ConsoleOut.printMessage(
                Message.PROCEEDS_PRINT.getMessage(), lottoCalculator.getProceedsRate(), getComment(proceeds));
    }

    private void printWinningResult(WinningResult winningResult, int count) {
        ConsoleOut.printMessage(
                Message.WIN_RESULTS_PRINT.getMessage(), winningResult.getCount(), winningResult.getPrize(), count);
    }

    private String getComment(float proceedsRate) {
        String comment = "";
        if (proceedsRate < LottoCalculator.PROFIT_RATE) {
            comment = Message.PROCEEDS_COMMENT.getMessage();
        }
        return comment;
    }
}
