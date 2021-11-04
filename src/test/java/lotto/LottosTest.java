package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Lottos 테스트")
class LottosTest {

    @Test
    @DisplayName("로또의 개수를 반환한다.")
    void size() {
        // given
        int quantity = 5;
        Lottos lottos = Lottos.fromQuantity(quantity);

        // when
        int size = lottos.size();

        // then
        assertThat(size).isEqualTo(quantity);
    }
}
