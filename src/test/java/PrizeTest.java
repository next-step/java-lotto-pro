import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {
    @Test
    void 같은_숫자_6개를_포함하고_있으면_2등이다() {
        assertThat(Prize.valueOf(6, false)).isEqualTo(Prize.FIRST);
        assertThat(Prize.valueOf(6, true)).isEqualTo(Prize.FIRST);
    }

    @Test
    void 같은_숫자_5개를_포함하고_보너스_숫자를_포함하고_있으면_2등이다() {
        assertThat(Prize.valueOf(5, true)).isEqualTo(Prize.SECOND);
    }

    @Test
    void 같은_숫자_5개를_포함하고_보너스_숫자를_포함하지_않고_있으면_3등이다() {
        assertThat(Prize.valueOf(5, false)).isEqualTo(Prize.THIRD);
    }

    @Test
    void 같은_숫자_4개를_포함하고_있으면_4등이다() {
        assertThat(Prize.valueOf(4, false)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.valueOf(4, true)).isEqualTo(Prize.FOURTH);
    }

    @Test
    void 같은_숫자_3개를_포함하고_있으면_5등이다() {
        assertThat(Prize.valueOf(3, false)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.valueOf(3, true)).isEqualTo(Prize.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 1, 0, -1 })
    void 같은_숫자_3개_미만을_포함하고_있으면_당첨되지_않는다(int count) {
        assertThat(Prize.valueOf(count, false)).isEqualTo(Prize.NONE);
        assertThat(Prize.valueOf(count, true)).isEqualTo(Prize.NONE);
    }

    @ParameterizedTest
    @ValueSource(ints = { Integer.MAX_VALUE, LottoNumbers.SIZE + 1 })
    void 등수에_적절하지_않은_값이_들어가면_당첨되지_않는다(int count) {
        assertThat(Prize.valueOf(count, false)).isEqualTo(Prize.NONE);
        assertThat(Prize.valueOf(count, true)).isEqualTo(Prize.NONE);
    }

    @ParameterizedTest
    @ValueSource(strings = { "FIRST", "SECOND", "THIRD", "FOURTH" })
    void 당첨되면_winner_이다(Prize prize) {
        assertThat(prize.win()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "NONE" })
    void 당첨되지_않으면_winner_가_아니다(Prize prize) {
        assertThat(prize.win()).isFalse();
    }

    @Test
    void 당첨_되면_받을_상금을_계산할_수_있다() {
        ContainCounts containCounts = new ContainCounts();
        containCounts.add(Prize.valueOf(5, true));
        containCounts.add(Prize.valueOf(5, true));
        containCounts.add(Prize.valueOf(5, true));
        assertThat(containCounts.totalPrize()).isEqualTo(30000000L);
    }

}
