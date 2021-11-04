package step3.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class LottoRankTest {
    @Test
    void listOf() {
        assertThat(LottoRank.listOf()).isEqualTo(LottoRank.listOf());
    }

    @Test
    void FIRST_name() {
        assertEquals("FIRST", LottoRank.FIRST.name());
    }

    @Test
    void incrementCountHasMatchNumber() {
        int matchCount = 5;
        Arrays.stream(LottoRank.listOf()).forEach(lottoRank -> {
            lottoRank.incrementCountHasMatchNumber(matchCount);
        });
    }
}
