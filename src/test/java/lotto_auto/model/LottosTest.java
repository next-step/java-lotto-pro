package lotto_auto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    public void 로또들_초기화() {
        lottos = new Lottos();
        lottos.appendLotto(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 로또들_프린트_테스트() {
        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }

    @Test
    void append_Lotto() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 10, 20");
        lottos.appendLotto(lotto);

        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 10, 20]\n");
    }
}
