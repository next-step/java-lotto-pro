package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaperTest {

    @DisplayName("랜덤횟수 조회 (전체횟수 - 수동횟수)")
    @Test
    void randomCount() {
        LottoPaper lottoPaper = new LottoPaper(10, 3);

        assertEquals(7,lottoPaper.randomCount());

    }

    @DisplayName("모든 구매로또가 전부 랜덤인지 여부 확인")
    @Test
    void isAllRandom() {
        LottoPaper lottoPaper = new LottoPaper(10, 0);

        assertThat(lottoPaper.isAllRandom()).isTrue();
    }
}
