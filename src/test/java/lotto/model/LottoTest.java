package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import lotto.constant.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 등수 구하기")
    @Test
    void matchRank() {
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 15, 25, 36, 45));
        assertAll(
                () -> assertEquals(LottoRank.FOURTH, lotto.matchRank(Arrays.asList(1, 10, 15, 40, 41, 45))),
                () -> assertEquals(LottoRank.THIRD, lotto.matchRank(Arrays.asList(1, 3, 15, 25, 41, 43))),
                () -> assertEquals(LottoRank.SECOND, lotto.matchRank(Arrays.asList(1, 10, 15, 25, 36, 45))),
                () -> assertEquals(LottoRank.FIRST, lotto.matchRank(Arrays.asList(1, 3, 15, 25, 36, 45)))
        );
    }

}
