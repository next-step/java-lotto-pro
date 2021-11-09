package lotto.state.manual;

import lotto.domain.*;
import lotto.state.State;

import java.io.PrintStream;
import java.util.List;

public class BonusNumberState implements State {

    private final BonusNumberStateView bonusNumberStateView;
    private final LotteryTicket lotteryTicket;
    private final WinningLottoNumbers winningLottoNumbers;

    public BonusNumberState(BonusNumberStateView bonusNumberStateView, LotteryTicket lotteryTicket, WinningLottoNumbers winningLottoNumbers) {
        this.bonusNumberStateView = bonusNumberStateView;
        this.lotteryTicket = lotteryTicket;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    @Override
    public void printQuestion(PrintStream out) {
        bonusNumberStateView.printQuestion(out);
    }

    @Override
    public void printResult(List<String> texts, PrintStream out) {
        Record record = new Record(lotteryTicket, new WinningLottoNumbers(winningLottoNumbers, LottoNumber.of(texts.get(0))));
        bonusNumberStateView.printResult(out, record);
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
