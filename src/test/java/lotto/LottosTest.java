package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 구입 개수만큼 반환 확인")
    public void validCount() {
        Lottos lottos = new Lottos(14);
        assertThat(lottos.allGames().size()).isEqualTo(14);
    }

}
