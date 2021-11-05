package lotto;

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
        lottoCalculator.printLottosSize();
        lottoCalculator.printLottos();
        ConsoleOut.newLine();
    }

    private void printStats() {
        ConsoleOut.newLine();
        ConsoleOut.printMessage("당첨 통계");
        ConsoleOut.printMessage("---------");
        lottoCalculator.printStats();
    }
}
