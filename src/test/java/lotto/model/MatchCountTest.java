package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatchCountTest {
    @Test
    void ofValue() {
        assertThat(MatchCount.SIX).isEqualTo(MatchCount.ofValue(6));
    }
}
