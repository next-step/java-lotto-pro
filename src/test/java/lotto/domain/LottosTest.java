package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    private AutoLottos autoLottos;
    private ManualLottos manualLottos;
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        autoLottos = new AutoLottos(2, new FakeNumbers());
        manualLottos = new ManualLottos(Arrays.asList("17, 18, 19, 20, 21, 22"));
        lottos = new Lottos(autoLottos, manualLottos);
    }

    @Test
    void 자동_로또들과_수동_로또들로_로또들을_생성한다() {
        assertThat(lottos.getLottos()).containsExactly(
                new Lotto("17, 18, 19, 20, 21, 22"),
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("11, 12, 13, 14, 15, 16")
        );
    }

    @Test
    void 당첨로또와_비교한다() {
        List<Rank> ranks = lottos.match(new WinningLotto("1, 2, 11, 12, 13, 14", 10));
        assertThat(ranks).contains(Rank.FORTH);
    }
}