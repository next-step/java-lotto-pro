import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregatorTest {
    private Aggregator aggregator;

    @BeforeEach
    void setUp() {
        Ranks ranks = new Ranks();
        ranks.add(Rank.FIRST);
        ranks.add(Rank.FIRST);
        ranks.add(Rank.FIRST);
        ranks.add(Rank.SECOND);
        ranks.add(Rank.SECOND);
        ranks.add(Rank.THIRD);
        ranks.add(Rank.FOURTH);
        ranks.add(Rank.FOURTH);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.FIFTH);
        ranks.add(Rank.NONE);
        ranks.add(Rank.NONE);

        aggregator = new Aggregator(ranks);
    }

    @ParameterizedTest
    @CsvSource(value = { "FIRST:3", "SECOND:2", "THIRD:1", "FOURTH:2", "NONE:2" }, delimiterString = ":")
    void 로또별_당첨번호_포함_갯수_목록_중_Prize_별_집계_갯수를_확인할_수_있다(Rank rank, long count) {
        assertThat(aggregator.countGroupBy(rank)).isEqualTo(count);
    }

    @Test
    void 총_구매금액에_대한_수익률_을_확인할_수_있다() {
        assertThat(aggregator.yield().setScale(0, RoundingMode.DOWN)).isEqualTo(new BigDecimal(169296));
    }
}
