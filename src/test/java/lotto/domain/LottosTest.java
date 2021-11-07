package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {

    @Test
    void 로또들을_생성한다() {
        Lottos lottos = new Lottos(2, new FakeNumbers());
        List<Lotto> expected = lottos.getLottos();
        assertAll(
                () -> assertThat(expected.size()).isEqualTo(2),
                () -> assertThat(expected.get(0)).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))),
                () -> assertThat(expected.get(1)).isEqualTo(new Lotto(Arrays.asList(11, 12, 13, 14, 15, 16)))
        );
    }

    @Test
    void 당첨로또와_비교한다() {
        Lottos lottos = new Lottos(2, new FakeNumbers());
        List<Rank> ranks = lottos.match(new WinningLotto("1, 2, 11, 12, 13, 14", 10));
        assertThat(ranks).contains(Rank.FORTH);
    }
}