package lotto.state.manual;

import lotto.domain.LotteryTicket;

import java.io.PrintStream;

public class ManualCountStateView {
    public void printQuestion(PrintStream out) {
        out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printResult(PrintStream out, LotteryTicket lotteryTicket) {
        new ManualBuyStateView().printResult(out, lotteryTicket);
    }
}
