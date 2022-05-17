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

}
