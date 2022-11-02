package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.Lottos.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.Lottos.MAX_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호들")
class LottosTest {

    @DisplayName("6개 이상의 수를 추가 할 수 없다.")
    @Test
    void maxSize() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(3));
        lottos.add(new Lotto(4));
        lottos.add(new Lotto(5));
        lottos.add(new Lotto(6));
        lottos.add(new Lotto(7));
        lottos.add(new Lotto(8));
        assertThatThrownBy(() -> lottos.add(new Lotto(9)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(MAX_SIZE + "를 초과할 수 없습니다.");
    }

    @DisplayName("중복된 수를 추가할 수 없다.")
    @Test
    void duplicate() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(3));
        assertThatThrownBy(() -> lottos.add(new Lotto(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_EXCEPTION_MESSAGE);
    }
}
