package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.*;
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
        lotto1 = new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(12),
                new LottoNumber(13),
               new LottoNumber(14))));

        lotto2 = new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber(11),
                new LottoNumber(22),
                new LottoNumber(33),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9))));

        lotto3 = new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(10),
                new LottoNumber(32),
                new LottoNumber(44),
                new LottoNumber(45))));

        lotto4 = new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber(43),
                new LottoNumber(42),
                new LottoNumber(31),
                new LottoNumber(12),
                new LottoNumber(45),
                new LottoNumber(14))));

        lotto5 = new Lotto(new LottoNumbers(Arrays.asList(new LottoNumber(21),
                new LottoNumber(9),
                new LottoNumber(3),
                new LottoNumber(32),
                new LottoNumber(4),
                new LottoNumber(45))));

        lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2, lotto3)));
        winningLotto = new WinningLotto(new LottoNumbers(Arrays.asList(new LottoNumber(1),
                                                                        new LottoNumber(2),
                                                                        new LottoNumber(3),
                                                                        new LottoNumber(4),
                                                                        new LottoNumber(5),
                                                                        new LottoNumber(6))), 8);
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

    @Test
    @DisplayName("두 로또 병합하여 새로운 로또 일급객체 생성")
    void unionLottos() {

        Lottos merged = lottos.unionLottos(new Lottos(new ArrayList<>(Arrays.asList(lotto4, lotto5))));

        Assertions.assertFalse(lottos.equals(merged));
        Assertions.assertEquals(5, merged.getLottos().size());
    }

}
