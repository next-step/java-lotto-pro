package lotto.state;

import lotto.auto.AutoLottoPrinter;
import lotto.domain.*;

import java.io.PrintStream;

public class FirstState implements State {
    private final FirstStateView firstStateView;
    private final Shuffleable shuffler;
    private LotteryTicket lotteryTicket;

    public FirstState(FirstStateView firstStateView, Shuffleable shuffler) {
        this.firstStateView = firstStateView;
        this.shuffler = shuffler;
    }

    @Override
    public void printResult(String text, PrintStream out) {
        firstStateView.printResult(out, getLotteryTicket(text));
    }

    protected LotteryTicket getLotteryTicket(String text) {
        Money money = Money.of(text);
        lotteryTicket = new LottoCashier(new AutoLottoPrinter(shuffler)).buy(money);
        return lotteryTicket;
    }

    @Override
    public void printQuestion(PrintStream out) {
        firstStateView.printQuestion(out);
    }

    @Override
    public State next() {
        return new SecondState(new SecondStateView(), lotteryTicket);
    }

    protected LotteryTicket getLotteryTicket() {
        return lotteryTicket;
    }
}
