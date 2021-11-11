package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTypesCountTest {
    @DisplayName("로또 타입별 개수를 반환한다")
    @Test
    void getCountOfType() {
        int manualCount = 3;
        int autoCount = 5;
        LottoTypesCount lottoTypesCount = new LottoTypesCount(manualCount, autoCount);
        assertEquals(manualCount, lottoTypesCount.getCountOfType(LottoType.MANUAL));
        assertEquals(autoCount, lottoTypesCount.getCountOfType(LottoType.AUTO));
    }

}
