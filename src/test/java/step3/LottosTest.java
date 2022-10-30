package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Lotto;
import step3.domain.LottoNumber;
import step3.domain.Lottos;
import step3.domain.WinningLotto;
import step3.enums.Rank;

class LottosTest {

    private Lottos lottos;
    private Lotto lotto1;
    private Lotto lotto2;
    private Lotto lotto3;
    private Lotto lotto4;
    private Lotto lotto5;
    WinningLotto winningLotto;
    private Map<Integer, Integer> statistics;

    @BeforeEach
    void init() {
        lotto1 = new Lotto(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 3, 12, 13, 14))));
        lotto2 = new Lotto(new LottoNumber(new ArrayList<>(Arrays.asList(11, 22, 33, 7, 8, 9))));
        lotto3 = new Lotto(new LottoNumber(new ArrayList<>(Arrays.asList(1, 2, 10, 32, 44, 45))));
        lotto4 = new Lotto(new LottoNumber(new ArrayList<>(Arrays.asList(43, 42, 31, 12, 14, 45))));
        lotto5 = new Lotto(new LottoNumber(new ArrayList<>(Arrays.asList(21, 9, 3, 32, 4, 45))));

        lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3)));
        winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 8);
        statistics = lottos.calculateWinningBallsEachLotto(winningLotto);
    }

    @Test
    void generateLottos() {
        Assertions.assertEquals(3, lottos.getLottos().size());
    }

    @Test
    void calculateWinningBallsEachLotto() {
        Assertions.assertEquals(1, Rank.statistic(statistics, 5000));

    }


}
