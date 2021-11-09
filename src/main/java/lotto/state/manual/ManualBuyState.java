package lotto.state.manual;

import lotto.domain.*;
import lotto.state.State;

import java.io.PrintStream;
import java.util.List;

public class ManualBuyState implements State {
    private final ManualBuyStateView manualBuyStateView;
    private final Money cash;
    private final int count;
    private LotteryTicket lotteryTicket;

    public ManualBuyState(ManualBuyStateView manualBuyStateView, Money cash, int count) {
        this.manualBuyStateView = manualBuyStateView;
        this.cash = cash;
        this.count = count;
    }

    @Override
    public void printQuestion(PrintStream out) {
        manualBuyStateView.printQuestion(out);
    }

    @Override
    public void printResult(List<String> texts, PrintStream out) {
        LottoCashier lottoCashier = new LottoCashier(new AutoLottoPrinter(new CollectionsShuffler()));
        lotteryTicket = lottoCashier.buy(cash, texts);
        manualBuyStateView.printResult(out, lotteryTicket);
    }

    @Override
    public State next() {
        return new WinningNumberState(new WinningNumberStateView(), lotteryTicket);
    }

    @Override
    public int readLineCount() {
        return count;
    }
}
