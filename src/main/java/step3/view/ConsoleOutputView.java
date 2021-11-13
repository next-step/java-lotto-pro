package step3.view;

import static java.text.MessageFormat.*;
import java.util.List;
import step3.domain.Lotto;
import step3.domain.LottoTicket;
import step3.domain.Money;

public class ConsoleOutputView {

    public void print(final String message) {
        System.out.println(message);
    }

    public void lineSeparator() {
        System.out.println();
    }

    public void error(final Throwable cause) {
        if (cause instanceof RuntimeException) {
            print(cause.getMessage());
            return;
        }

        print("오류가 발생했습니다.");
    }

    public void printMoney(final Money money) {
        print(format("{0}개를 구매했습니다.", money.exchangeLottoPurchasableCount()));
    }

    public void printLottoTicket(final LottoTicket lottoTicket) {
        final List<Lotto> lotteries = lottoTicket.get();

        for (final Lotto lotto : lotteries) {
            print(lotto.toString());
        }
    }
}
