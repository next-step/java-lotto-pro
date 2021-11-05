package lotto.auto;

import lotto.domain.*;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

public class FirstState {
    private final FirstStateView firstStateView;
    private final Shuffleable shuffler;

    public FirstState(FirstStateView firstStateView, Shuffleable shuffler) {
        this.firstStateView = firstStateView;
        this.shuffler = shuffler;
    }

    public void printResult(String text, PrintStream out) {
        firstStateView.printResult(out, getResult(text));
    }

    protected List<String> getResult(String text) {
        Money money = Money.of(text);
        List<LottoNumbers> result = new LottoCashier(new AutoLottoPrinter(shuffler)).buy(money);
        return result.stream()
                .map(LottoNumbers::toString)
                .collect(Collectors.toList());
    }

    public void printQuestion(PrintStream out) {
        firstStateView.printQuestion(out);
    }
}
