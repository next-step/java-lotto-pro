import lotto.Match;
import lotto.MatchPrizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchPrizesTest {

    MatchPrizes matchPrizes;

    @BeforeEach
    void init() {
        Map<Match, Integer> m = new HashMap<>();
        m.put(new Match(3), 5000);
        m.put(new Match(4), 50000);
        m.put(new Match(5), 1500000);
        m.put(new Match(6), 2000000000);
        matchPrizes = new MatchPrizes(m);
    }

    @Test
    void 당첨금_대상() {
        boolean result = matchPrizes.has(new Match(3));
        assertThat(result).isTrue();
    }

    @Test
    void 당첨금_비대상() {
        boolean result = matchPrizes.has(new Match(2));
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"4:50000", "2:0"}, delimiter = ':')
    void 당첨금_액수(int input, int expectedPrize) {
        int prizeMoney = matchPrizes.prizeMoney(new Match(input));
        assertThat(prizeMoney).isEqualTo(expectedPrize);
    }
}
