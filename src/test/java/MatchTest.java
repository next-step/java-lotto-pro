import lotto.Match;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatchTest {

    @Test
    void 생성() {
        Match match = new Match(6);
        assertThat(match).asString().isEqualTo("6");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 7})
    void 생성_예외(int input) {
        assertThatThrownBy(() -> {
            new Match(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
