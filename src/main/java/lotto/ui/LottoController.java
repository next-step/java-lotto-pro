package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoCalculator;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {

    private static final String BLANK = " ";
    public static final int MANUAL_LOTTOS_EXIST = 0;

    public void run() {
        LottoCalculator lottoCalculator = getLottoCalculator();

        ConsoleOut.newLine();
        printLottos(lottoCalculator);

        lottoCalculator.calculate(new WinningLotto(ConsoleIn.inputLotto(Message.WIN_NUMBER_INPUT), ConsoleIn.inputBonusNumber()));
        WinningResults winningResults = lottoCalculator.getWinningResults();

        printHeader();
        printWinningResults(winningResults);
        printProceedsRate(lottoCalculator, winningResults);
    }

    private LottoCalculator getLottoCalculator() {
        PurchaseAmount purchaseAmount = ConsoleIn.inputPurchaseAmount();
        ConsoleOut.newLine();
        Integer manualQuantity = ConsoleIn.inputManualQuantity();
        ConsoleOut.newLine();
        return new LottoCalculator(purchaseAmount, new Lottos(getManualLottos(manualQuantity), manualQuantity));
    }

    private List<Lotto> getManualLottos(Integer manualQuantity) {
        List<Lotto> manualLottos = new ArrayList<>();
        if (manualQuantity > MANUAL_LOTTOS_EXIST) {
            manualLottos.add(ConsoleIn.inputLotto(Message.MANUAL_NUMBER_INPUT));
        }
        manualLottos.addAll(
                IntStream.range(0, manualQuantity - 1)
                        .mapToObj(ignored -> ConsoleIn.inputLotto(Message.EMPTY))
                        .collect(Collectors.toList())
        );
        return manualLottos;
    }

    private void printLottos(LottoCalculator lottoCalculator) {
        ConsoleOut.printMessage(Message.LOTTOS_PRINT.getMessage(),
                lottoCalculator.getManualQuantity(), lottoCalculator.getAutoQuantity());
        for (Lotto lotto : lottoCalculator.getLottos().getLottos()) {
            ConsoleOut.printMessage(getLottoMessage(lotto));
        }
        ConsoleOut.newLine();
    }

    private String getLottoMessage(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(", ", "[", "]"));
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

    private void printProceedsRate(LottoCalculator lottoCalculator, WinningResults winningResults) {
        long proceeds = winningResults.getProceeds();
        ConsoleOut.printMessage(
                Message.PROCEEDS_PRINT.getMessage(), lottoCalculator.getProceedsRate(), getCommentMessage(proceeds));
    }

    private void printWinningResult(WinningResult winningResult, int count) {
        ConsoleOut.printMessage(
                Message.WIN_RESULTS_PRINT.getMessage(), winningResult.getCount(), getBonusNumberMessage(winningResult),
                winningResult.getPrize(), count);
    }

    private String getCommentMessage(float proceedsRate) {
        String message = "";
        if (proceedsRate < LottoCalculator.PROFIT_RATE) {
            message = Message.PROCEEDS_COMMENT.getMessage();
        }
        return message;
    }

    private String getBonusNumberMessage(WinningResult winningResult) {
        String message = BLANK;
        if (winningResult.isBonusNumberMatched()) {
            message = Message.WIN_RESULTS_BONUS_NUMBER.getMessage();
        }
        return message;
    }
}
