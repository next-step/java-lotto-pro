package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MatchCountTest {
    @Test
    void equals() {
        assertThat(new MatchCount(6)).isEqualTo(new MatchCount(6));
    }
}
