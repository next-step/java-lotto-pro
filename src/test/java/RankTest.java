import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @Test
    void 같은_숫자_6개를_포함하고_있으면_2등이다() {
        assertThat(Rank.valueOf(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.valueOf(6, true)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 같은_숫자_5개를_포함하고_보너스_숫자를_포함하고_있으면_2등이다() {
        assertThat(Rank.valueOf(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 같은_숫자_5개를_포함하고_보너스_숫자를_포함하지_않고_있으면_3등이다() {
        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 같은_숫자_4개를_포함하고_있으면_4등이다() {
        assertThat(Rank.valueOf(4, false)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.valueOf(4, true)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 같은_숫자_3개를_포함하고_있으면_5등이다() {
        assertThat(Rank.valueOf(3, false)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.valueOf(3, true)).isEqualTo(Rank.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 1, 0, -1 })
    void 같은_숫자_3개_미만을_포함하고_있으면_당첨되지_않는다(int count) {
        assertThat(Rank.valueOf(count, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(count, true)).isEqualTo(Rank.NONE);
    }

    @ParameterizedTest
    @ValueSource(ints = { Integer.MAX_VALUE, LottoNumbers.SIZE + 1 })
    void 등수에_적절하지_않은_값이_들어가면_당첨되지_않는다(int count) {
        assertThat(Rank.valueOf(count, false)).isEqualTo(Rank.NONE);
        assertThat(Rank.valueOf(count, true)).isEqualTo(Rank.NONE);
    }

    @ParameterizedTest
    @ValueSource(strings = { "FIRST", "SECOND", "THIRD", "FOURTH" })
    void 당첨되면_winner_이다(Rank rank) {
        assertThat(rank.win()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = { "NONE" })
    void 당첨되지_않으면_winner_가_아니다(Rank rank) {
        assertThat(rank.win()).isFalse();
    }

    @Test
    void 당첨_되면_받을_상금을_계산할_수_있다() {
        Ranks ranks = new Ranks();
        ranks.add(Rank.valueOf(5, true));
        ranks.add(Rank.valueOf(5, true));
        ranks.add(Rank.valueOf(5, true));
        assertThat(ranks.totalPrize()).isEqualTo(30000000L);
    }

}
