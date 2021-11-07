package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoController {

    private final LottoCalculator lottoCalculator;

    public LottoController() {
        this.lottoCalculator = new LottoCalculator(ConsoleIn.inputPurchaseAmount());
        printLottos();
    }

    public void run() {
        lottoCalculator.calculate(new WinningLotto(ConsoleIn.inputWinNumber(), ConsoleIn.inputBonusNumber()));
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
        Map<WinningResult, Integer> winningResultCounts = new HashMap<>();
        for (WinningResult winningResult : winningResults.getWinningResults()) {
            winningResultCounts.put(winningResult, winningResultCounts.getOrDefault(winningResult, 0) + 1);
        }

        Arrays.stream(WinningResult.values())
                .filter(winningResult -> winningResult != WinningResult.NOT_MATCHED)
                .forEach(winningResult ->
                        printWinningResult(winningResult, winningResultCounts.getOrDefault(winningResult, 0)));
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
