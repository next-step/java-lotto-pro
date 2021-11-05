package lotto.auto;

import lotto.domain.*;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class FirstState implements State {
    private final FirstStateView firstStateView;
    private final Shuffleable shuffler;
    private List<LottoNumbers> result;

    public FirstState(FirstStateView firstStateView, Shuffleable shuffler) {
        this.firstStateView = firstStateView;
        this.shuffler = shuffler;
    }

    @Override
    public void printResult(String text, PrintStream out) {
        firstStateView.printResult(out, getResult(text));
    }

    protected List<String> getResult(String text) {
        Money money = Money.of(text);
        result = new LottoCashier(new AutoLottoPrinter(shuffler)).buy(money);
        return result.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.toList());
    }

    @Override
    public void printQuestion(PrintStream out) {
        firstStateView.printQuestion(out);
    }

    @Override
    public State next() {
        return new SecondState(new SecondStateView(), result);
    }

    @Override
    public boolean isFinish() {
        return false;
    }
}
