package lotto.state.manual;

import lotto.domain.Money;
import lotto.state.State;

import java.io.PrintStream;
import java.util.List;

public class ManualStartState implements State {

    private final ManualStartStateView manualStartStateView;
    private Money cash;

    public ManualStartState(ManualStartStateView manualStartStateView) {
        this.manualStartStateView = manualStartStateView;
    }

    @Override
    public void printQuestion(PrintStream out) {
        manualStartStateView.printQuestion(out);
    }

    @Override
    public void printResult(List<String> textLottoNumbers, PrintStream out) {
        cash = Money.of(textLottoNumbers.get(0));
    }

    @Override
    public State next() {
        return new ManualCountState(new ManualCountStateView(), cash);
    }
}
