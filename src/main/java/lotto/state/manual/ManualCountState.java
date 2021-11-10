package lotto.state.manual;

import lotto.domain.*;
import lotto.state.State;

import java.io.PrintStream;
import java.util.List;

public class ManualCountState implements State {
    private final ManualCountStateView manualCountStateView;
    private final Money cash;
    private int count;
    private State nextState;

    public ManualCountState(ManualCountStateView manualCountStateView, Money cash) {
        this.manualCountStateView = manualCountStateView;
        this.cash = cash;
    }

    @Override
    public void printQuestion(PrintStream out) {
        manualCountStateView.printQuestion(out);
    }

    @Override
    public void printResult(List<String> textLottoNumbers, PrintStream out) {
        count = parseInt(textLottoNumbers.get(0));
        if (!LottoCashier.isPossibleToBuy(cash, count)) {
            throw new IllegalArgumentException("구입 가능한 매수를 초과했습니다");
        }
        nextState = new ManualBuyState(new ManualBuyStateView(), cash, count);
        if (count == 0) {
            LottoCashier lottoCashier = new LottoCashier(new AutoLottoPrinter(new CollectionsShuffler()));
            LotteryTicket lotteryTicket = lottoCashier.buy(cash);
            nextState = new WinningNumberState(new WinningNumberStateView(), lotteryTicket);
            manualCountStateView.printResult(out, lotteryTicket);
        }
    }

    private int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요");
        }
    }

    @Override
    public State next() {
        return nextState;
    }
}
