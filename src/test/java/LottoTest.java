import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoTest {
    @Test
    void Lotto를_추가할_수_있다() {
        Lotto lotto = Lotto.empty();
        assertDoesNotThrow(() -> {
            lotto.add(new LottoNumbers(
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
    void Lotto_의_크기를_알_수_있다() {
        Lotto lotto = Lotto.empty();
        assertThat(lotto.size()).isZero();
    }

    @Test
    void 다른_Lotto_로_새로운_Lotto_를_생성할_수_있다() {
        Lotto addedLotto = Lotto.empty();
        addedLotto.add(new LottoNumbers(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        Lotto lotto = Lotto.of(addedLotto);

        assertThat(lotto).isNotEqualTo(addedLotto);
        assertThat(lotto.size()).isPositive();
    }

}
