package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoStatus별 당첨 금액을 관리하는 클래스 테스트")
class AmountByLottoStatusTest {

    private AmountByLottoStatus amountByLottoStatus;

    @BeforeEach
    void setUp() {
        amountByLottoStatus = new AmountByLottoStatus();
        amountByLottoStatus.accumulate(LottoStatus.FOURTH_PLACE);
        amountByLottoStatus.accumulate(LottoStatus.SECOND_PLACE);
    }

    @Test
    void 전체_당첨_누적_금액() {
        assertEquals(1505000, amountByLottoStatus.sumTotalAmount());
    }

    @Test
    void LottoStatus별_당첨_개수() {
        Map<LottoStatus, Long> countsByLottoStatus = amountByLottoStatus.countsByLottoStatus();
        assertAll(
                () -> assertEquals(1L, countsByLottoStatus.get(LottoStatus.FOURTH_PLACE)),
                () -> assertEquals(0L, countsByLottoStatus.get(LottoStatus.THIRD_PLACE)),
                () -> assertEquals(1L, countsByLottoStatus.get(LottoStatus.SECOND_PLACE)),
                () -> assertEquals(0L, countsByLottoStatus.get(LottoStatus.FIRST_PLACE))
        );
    }


}
