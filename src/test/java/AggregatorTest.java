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
        ranks.add(Prize.FIRST);
        ranks.add(Prize.FIRST);
        ranks.add(Prize.FIRST);
        ranks.add(Prize.SECOND);
        ranks.add(Prize.SECOND);
        ranks.add(Prize.THIRD);
        ranks.add(Prize.FOURTH);
        ranks.add(Prize.FOURTH);
        ranks.add(Prize.FIFTH);
        ranks.add(Prize.FIFTH);
        ranks.add(Prize.NONE);
        ranks.add(Prize.NONE);

        aggregator = new Aggregator(ranks);
    }

    @ParameterizedTest
    @CsvSource(value = { "FIRST:3", "SECOND:2", "THIRD:1", "FOURTH:2", "NONE:2" }, delimiterString = ":")
    void 로또별_당첨번호_포함_갯수_목록_중_Prize_별_집계_갯수를_확인할_수_있다(Prize prize, long count) {
        assertThat(aggregator.countGroupBy(prize)).isEqualTo(count);
    }

    @Test
    void 총_구매금액에_대한_수익률_을_확인할_수_있다() {
        assertThat(aggregator.yield().setScale(0, RoundingMode.DOWN)).isEqualTo(new BigDecimal(169296));
    }
}
