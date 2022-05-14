package lottoauto.domain;

import lottoauto.wrapper.Lotto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnerCheckerTest {
    WinnerChecker winnerChecker;
    @Test
    void 당첨_일치_확인() {
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i < 7 ; i++) {
            list.add(i);
        }
        Lotto winnerLotto = new Lotto(list);
        Lotto compareLotto = new Lotto(list);

        winnerChecker = new WinnerChecker(winnerLotto);

        winnerChecker.checkMatchNumbers(compareLotto);

    }
}