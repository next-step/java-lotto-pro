import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottosTest {
    @Test
    void Lotto를_추가할_수_있다() {
        Lottos lottos = new Lottos();
        assertDoesNotThrow(() -> {
            lottos.add(new LottoNumbers(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
        });
    }

    @Test
    void Lottos_의_크기를_알_수_있다() {
        Lottos lottos = new Lottos();
        assertThat(lottos.size()).isEqualTo(0);
    }

}
