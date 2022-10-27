package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Lotto;
import step3.domain.Lottos;
import step3.enums.Award;

class LottosTest {

    private Lottos lottos;
    private Lotto lotto1;
    private Lotto lotto2;
    private String winningNumbers;

    @BeforeEach
    void init() {
        lotto1 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 7, 8, 9)));
        lottos = new Lottos(new ArrayList<>(Arrays.asList(lotto1, lotto2)));
        winningNumbers = "1, 2, 3, 4, 5, 6";
        lottos.matchWinningNumbers(winningNumbers, 45);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void generateLottos(int input) {
        lottos = new Lottos();
        Assertions.assertEquals(input, lottos.generateLottos(input).size());
    }

    @Test
    public void matchWinningNumbers() {
        Assertions.assertEquals(6, lotto1.getMatchCount());
        Assertions.assertEquals(3, lotto2.getMatchCount());
    }

    @Test
    void calculateWinningBallsEachLotto() {
        Map<Integer, Integer> statistics = lottos.calculateWinningBallsEachLotto();
        Assertions.assertEquals(1, statistics.get(Award.THREE.getCount()));
        Assertions.assertEquals(0, statistics.get(Award.FOUR.getCount()));
        Assertions.assertEquals(0, statistics.get(Award.FIVE.getCount()));
        Assertions.assertEquals(1, statistics.get(Award.SIX.getCount()));

    }
}
