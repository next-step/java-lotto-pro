package lotto.ui;

import lotto.domain.LottoCalculator;
import lotto.domain.Prints;

public class LottoController {

    private final LottoCalculator lottoCalculator;

    public LottoController() {
        this.lottoCalculator = new LottoCalculator(ConsoleIn.inputPurchaseAmount());
    }

    public void run() {
        printLottos();
        lottoCalculator.calculate(ConsoleIn.inputWinNumber());
        printStats();
    }

    private void printLottos() {
        printAll(lottoCalculator.getLottosPrints());
        ConsoleOut.newLine();
    }

    private void printStats() {
        ConsoleOut.newLine();
        ConsoleOut.printMessage("당첨 통계");
        ConsoleOut.printMessage("---------");
        printAll(lottoCalculator.getStatsPrints());
    }

    private void printAll(Prints prints) {
        for (String print : prints.getPrints()) {
            ConsoleOut.printMessage(print);
        }
    }
}
