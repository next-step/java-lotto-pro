package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("Rank valueOf 테스트")
    @Test
    void valueOf() {
        assertEquals(Rank.FIRST, Rank.valueOf(6));
        assertEquals(Rank.SECOND, Rank.valueOf(5));
        assertEquals(Rank.THIRD, Rank.valueOf(4));
        assertEquals(Rank.FIFTH, Rank.valueOf(3));
        assertEquals(Rank.MISS, Rank.valueOf(2));
        assertEquals(Rank.MISS, Rank.valueOf(1));
        assertEquals(Rank.MISS, Rank.valueOf(0));
    }
}
