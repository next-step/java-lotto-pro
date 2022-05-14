package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("")
    void Lottos_초기화_테스트(){
        Lottos lottos = new Lottos();
        lottos.addRandomLotto();
        assertThat(lottos.size()).isEqualTo(1);
    }
}
