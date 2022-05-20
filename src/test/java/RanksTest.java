import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RanksTest {
    private Ranks ranks;

    @BeforeEach
    void setUp() {
        ranks = new Ranks();

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
    }

    @Test
    void Ranks에_Rank를_추가할_수_있다() {
        assertDoesNotThrow(() -> {
            ranks.add(Rank.NONE);
        });
    }

    @Test
    void Ranks_의_크기를_알_수_있다() {
        assertThat(ranks.size()).isPositive();
    }

    @ParameterizedTest
    @CsvSource(value = { "FIRST:3", "SECOND:2", "THIRD:1", "FOURTH:2", "NONE:2" }, delimiterString = ":")
    void Rank_별_갯수를_확인할_수_있다(Rank rank, long count) {
        assertThat(ranks.count(rank)).isEqualTo(count);
    }

    @Test
    void 당첨_되면_받을_상금을_계산할_수_있다() {
        assertThat(ranks.totalMoney()).isEqualTo(Arrays.stream(Rank.values()).mapToLong(Rank::money).sum());
    }

    @Test
    void 수익률을_계산할_수_있다() {
        BigDecimal yield = ranks.yield();
        assertThat(yield.setScale(2, RoundingMode.DOWN).doubleValue()).isEqualTo(169296.25);
    }
}
