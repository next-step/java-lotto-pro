package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("정상적인 Rank 를 반환하는지 확인한다")
    @Test
    void valueOf() {
        assertEquals(Rank.FIRST, Rank.valueOf(6, false));
        assertEquals(Rank.SECOND, Rank.valueOf(5, true));
        assertEquals(Rank.THIRD, Rank.valueOf(5, false));
        assertEquals(Rank.FOURTH, Rank.valueOf(4, false));
        assertEquals(Rank.FIFTH, Rank.valueOf(3, false));
        assertEquals(Rank.MISS, Rank.valueOf(2, false));
        assertEquals(Rank.MISS, Rank.valueOf(1, false));
        assertEquals(Rank.MISS, Rank.valueOf(0, false));
    }

    @DisplayName("Rank 객체를 확인하는 메서드가 정상적으로 동작하는지 확인한다")
    @Test
    void is() {
        assertTrue(Rank.FIRST.isFirst());
        assertTrue(Rank.SECOND.isSecond());
        assertTrue(Rank.THIRD.isThird());
        assertTrue(Rank.FOURTH.isFourth());
        assertTrue(Rank.FIFTH.isFifth());

        assertFalse(Rank.FIRST.isSecond());
        assertFalse(Rank.SECOND.isFirst());
        assertFalse(Rank.THIRD.isFifth());
        assertFalse(Rank.FOURTH.isFifth());
        assertFalse(Rank.FIFTH.isThird());
    }
}
