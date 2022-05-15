package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    void gameCountTest() {
        Lottos lottos = new Lottos();
        assertThat(lottos.gameCount())
                .isEqualTo(0);

        lottos.addLotto(new ArrayList<>());
        assertThat(lottos.gameCount())
                .isEqualTo(1);
    }

    @Test
    void getLotto() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lottos lottos = new Lottos();
        lottos.addLotto(numbers);

        assertThat(lottos.getLotto(0))
                .isEqualTo(new Lotto(numbers));
    }
}