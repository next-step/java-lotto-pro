package lotto.state.bonus;

import lotto.domain.*;
import lotto.state.FinishState;
import lotto.state.State;

import java.io.PrintStream;

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
    public void printResult(String text, PrintStream out) {
        Record record = new Record(lotteryTicket, new WinningLottoNumbers(winningLottoNumbers, new LottoNumber(text)));
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
