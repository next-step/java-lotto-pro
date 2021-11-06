package lotto.model.dto.enums;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.model.dto.enums.MatchCount;

public class MatchCountTest {
    @Test
    void ofValue() {
        assertThat(MatchCount.SIX).isEqualTo(MatchCount.ofValue(6));
    }
}
