import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void 같은_숫자_6개를_포함하고_있으면_2등이다() {
        assertThat(Prize.find(6)).isEqualTo(Prize.FIRST);
    }

    @Test
    void 같은_숫자_5개를_포함하고_있으면_2등이다() {
        assertThat(Prize.find(5)).isEqualTo(Prize.SECOND);
    }

    @Test
    void 같은_숫자_4개를_포함하고_있으면_3등이다() {
        assertThat(Prize.find(4)).isEqualTo(Prize.THIRD);
    }

    @Test
    void 같은_숫자_3개를_포함하고_있으면_4등이다() {
        assertThat(Prize.find(3)).isEqualTo(Prize.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 1, 0 })
    void 같은_숫자_3개_미만을_포함하고_있으면_당첨되지_않는다(int count) {
        assertThat(Prize.find(count)).isEqualTo(Prize.NONE);
    }

}
