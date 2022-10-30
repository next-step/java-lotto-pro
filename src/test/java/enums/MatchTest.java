package enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class MatchTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("매치 find 테스트")
    void find_match_test() {
        Match match = Match.findMatch(3);

        assumingThat(match.equals(Match.findMatch(3)), () -> {
            assertThat(match.getCount()).isEqualTo(3);
            assertThat(match.getAmount()).isEqualTo(5000);
        });
    }
}