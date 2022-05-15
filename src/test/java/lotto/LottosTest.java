package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    void 입력받은_수량만큼_로또발급(int quantity) {
        Lottos lottos = new Lottos(quantity);

        assertThat(lottos.getLottos()).hasSize(quantity);
    }

    @Test
    void 당첨_결과_확인() {
        List<Lotto> input = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("2, 3, 4, 5, 6, 7"));

        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");

        Lottos lottos = new Lottos(input);

        assertThat(lottos.getRanks(winningLotto)).contains(Rank._1ST);
        assertThat(lottos.getRanks(winningLotto)).contains(Rank._2ST);
    }

}