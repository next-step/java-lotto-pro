package lotto.auto;

import lotto.domain.LottoNumbers;
import lotto.domain.Record;

import java.io.PrintStream;
import java.util.List;

public class SecondState implements State {
    private final SecondStateView secondStateView;
    private final List<LottoNumbers> lottoNumbersList;

    public SecondState(SecondStateView secondStateView, List<LottoNumbers> record) {
        this.secondStateView = secondStateView;
        this.lottoNumbersList = record;
    }

    @Override
    public void printQuestion(PrintStream out) {
        secondStateView.printQuestion(out);
    }

    @Override
    public void printResult(String text, PrintStream out) {
        secondStateView.printResult(out, new Record(lottoNumbersList, LottoNumbers.of(text)));
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
