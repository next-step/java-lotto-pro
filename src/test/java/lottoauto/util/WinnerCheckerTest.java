package lottoauto.util;

import lottoauto.wrapper.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerCheckerTest {
    @Test
    void 당첨번호_선입력() {
        Lotto winnerLotto = new Lotto();
        WinnerChecker winnerChecker = new WinnerChecker(winnerLotto);

        assertThat(winnerChecker.toString()).isEqualTo(winnerLotto.toString());
    }

    @Test
    void 비교할번호_입력() {
        Lotto winnerLotto = new Lotto("1, 2, 5, 6, 7, 8");
        WinnerChecker winnerChecker = new WinnerChecker(winnerLotto);
        System.out.println(winnerLotto.toString());
        Lotto comparableLotto = new Lotto("1, 2, 3, 4, 5, 6");
        System.out.println(comparableLotto.toString());
        System.out.println(winnerChecker.compareTickets(comparableLotto));

    }
}
