package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void LottoStatus별_당첨_누적_금액() {
        assertEquals(1L, amountByLottoStatus.countByLottoStatus(LottoStatus.FOURTH_PLACE));
        assertEquals(1L, amountByLottoStatus.countByLottoStatus(LottoStatus.SECOND_PLACE));
    }
}
