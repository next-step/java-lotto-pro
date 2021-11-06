package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    public static final Lotto 로또 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void 로또를_생성한다() {
        assertThat(로또).isEqualTo(로또);
    }

    @Test
    void 로또는_6개의_숫자만_가진다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void 로또는_중복되지_않는다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 6, 6)));
    }

    @Test
    void 숫자_문자열로_생성한다() {
        assertThat(new Lotto("1, 2, 3, 4, 5, 6")).isEqualTo(로또);
    }

    @Test
    void 보너스_숫자를_확인한다() {
        assertThat(로또.containBonus(new Bonus(1))).isTrue();
    }
}
