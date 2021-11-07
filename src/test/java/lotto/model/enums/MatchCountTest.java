package lotto.model.enums;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatchCountTest {
    @Test
    void valueOf() {
        assertThat(MatchCount.SIX).isEqualTo(MatchCount.valueOf(6));
    }
}
