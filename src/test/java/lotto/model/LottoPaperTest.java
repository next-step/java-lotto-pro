package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaperTest {

    @DisplayName("랜덤횟수를 가져온다(전체횟수 - 수동횟수)")
    @Test
    void randomCount() {
        LottoPaper lottoPaper = new LottoPaper(10, 3);

        assertEquals(7,lottoPaper.randomCount());

    }
}
