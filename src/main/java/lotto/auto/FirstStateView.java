package lotto.auto;

import lotto.domain.LotteryTicket;
import lotto.domain.LottoNumbers;

import java.io.PrintStream;

public class FirstStateView {
    public void printQuestion(PrintStream out) {
        out.println("구입금액을 입력해 주세요.");
    }

    public void printResult(PrintStream out, LotteryTicket lotteryTicket) {
        out.printf("%d개를 구매했습니다.%n", lotteryTicket.size());
        for (LottoNumbers lottoNumbers : lotteryTicket.getLottoNumbersList()) {
            out.println(lottoNumbers);
        }
        out.println();
    }
}
