package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    private static final Lotto 로또 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

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
    void 당첨번호_개수를_반환한다() {
        Lotto 당첨_로또 = new Lotto(Arrays.asList(1, 2, 3, 10, 11, 12));
        assertThat(당첨_로또.match(로또)).isEqualTo(3);
    }

    @Test
    void 숫자_문자열로_생성한다() {
        assertThat(new Lotto("1, 2, 3, 4, 5, 6")).isEqualTo(로또);
    }
}
