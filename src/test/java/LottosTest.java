import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottosTest {
    @Test
    void Lotto를_추가할_수_있다() {
        Lottos lottos = new Lottos();
        assertDoesNotThrow(() -> lottos.add(new LottoNumbers()));
    }

    @Test
    void Lottos_의_크기를_알_수_있다() {
        Lottos lottos = new Lottos();
        assertThat(lottos.size()).isEqualTo(2);
    }

}
