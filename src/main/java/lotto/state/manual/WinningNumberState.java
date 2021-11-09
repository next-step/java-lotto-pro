package lotto.state.manual;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumbers;
import lotto.domain.WinningLottoNumbers;
import lotto.state.State;

import java.io.PrintStream;
import java.util.List;

public class WinningNumberState implements State {
    private final WinningNumberStateView winningNumberStateView;
    private final LotteryTicket lotteryTicket;
    private WinningLottoNumbers winningLottoNumbers;

    public WinningNumberState(WinningNumberStateView winningNumberStateView, LotteryTicket lotteryTicket) {
        this.winningNumberStateView = winningNumberStateView;
        this.lotteryTicket = lotteryTicket;
    }

    @Override
    public void printQuestion(PrintStream out) {
        winningNumberStateView.printQuestion(out);
    }

    @Override
    public void printResult(List<String> texts, PrintStream out) {
        winningLottoNumbers = new WinningLottoNumbers(LottoNumbers.of(texts.get(0)));
    }

    @Override
    public State next() {
        return new BonusNumberState(new BonusNumberStateView(), lotteryTicket, winningLottoNumbers);
    }
}
