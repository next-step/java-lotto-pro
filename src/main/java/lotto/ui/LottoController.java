package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.WinResult;
import lotto.domain.WinResults;

import java.util.Arrays;

public class LottoController {

    private final LottoCalculator lottoCalculator;

    public LottoController() {
        this.lottoCalculator = new LottoCalculator(ConsoleIn.inputPurchaseAmount());
        printLottos();
    }

    public void run() {
        lottoCalculator.calculate(ConsoleIn.inputWinNumber());
        WinResults winResults = lottoCalculator.getWinResults();

        printHeader();
        printWinResults(winResults);
        printProceedsRate(winResults);
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

    private void printWinResults(WinResults winResults) {
        Arrays.stream(WinResult.values())
                .filter(winResult -> winResult != WinResult.NOT_MATCHED)
                .forEach(winResult -> printWinResult(winResult, winResults.getCount(winResult.getCount())));
    }

    private void printProceedsRate(WinResults winResults) {
        long proceeds = winResults.getProceeds();
        ConsoleOut.printMessage(
                Message.PROCEEDS_PRINT.getMessage(), lottoCalculator.getProceedsRate(), getComment(proceeds));
    }

    private void printWinResult(WinResult winResult, int count) {
        ConsoleOut.printMessage(
                Message.WIN_RESULTS_PRINT.getMessage(), winResult.getCount(), winResult.getPrize(), count);
    }

    private String getComment(float proceedsRate) {
        String comment = "";
        if (proceedsRate < LottoCalculator.PROFIT_RATE) {
            comment = Message.PROCEEDS_COMMENT.getMessage();
        }
        return comment;
    }
}
