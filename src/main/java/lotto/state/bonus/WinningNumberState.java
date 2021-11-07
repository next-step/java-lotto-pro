package lotto.state.bonus;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLottoNumbers;
import lotto.state.SecondStateView;
import lotto.state.State;

import java.io.PrintStream;

public class WinningNumberState implements State {
    private final SecondStateView secondStateView;
    private final LotteryTicket lotteryTicket;
    private WinningLottoNumbers winningLottoNumbers;

    public WinningNumberState(SecondStateView secondStateView, LotteryTicket lotteryTicket) {
        this.secondStateView = secondStateView;
        this.lotteryTicket = lotteryTicket;
    }

    @Override
    public void printQuestion(PrintStream out) {
        secondStateView.printQuestion(out);
    }

    @Override
    public void printResult(String text, PrintStream out) {
        winningLottoNumbers = new WinningLottoNumbers(LottoNumbers.of(text));
    }

    @Override
    public State next() {
        return new BonusNumberState(new BonusNumberStateView(), lotteryTicket, winningLottoNumbers);
    }
}
