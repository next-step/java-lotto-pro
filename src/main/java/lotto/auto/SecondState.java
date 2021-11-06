package lotto.auto;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumbers;
import lotto.domain.Record;

import java.io.PrintStream;

public class SecondState implements State {
    private final SecondStateView secondStateView;
    private final LotteryTicket lotteryTicket;

    public SecondState(SecondStateView secondStateView, LotteryTicket lotteryTicket) {
        this.secondStateView = secondStateView;
        this.lotteryTicket = lotteryTicket;
    }

    @Override
    public void printQuestion(PrintStream out) {
        secondStateView.printQuestion(out);
    }

    @Override
    public void printResult(String text, PrintStream out) {
        secondStateView.printResult(out, new Record(lotteryTicket, LottoNumbers.of(text)));
    }

    @Override
    public State next() {
        return new FinishState();
    }

    @Override
    public boolean isFinish() {
        return false;
    }
}
