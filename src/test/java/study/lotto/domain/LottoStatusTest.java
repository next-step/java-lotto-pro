package study.lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또의 당첨 상태를 테스트")
class LottoStatusTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7, 8, 9})
    void LottoStatus에_존재하지_않는_타입(int result) {
        Assertions.assertEquals(LottoStatus.NONE,
                LottoStatus.getLottoStatus(result, false));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:FIFTH_PLACE", "4:FOURTH_PLACE", "5:THIRD_PLACE", "6:FIRST_PLACE"},
            delimiter = ':')
    void LottoStatus에_존재하는_타입(int result, LottoStatus expected) {
        assertEquals(expected, LottoStatus.getLottoStatus(result, false));
    }

    @Test
    void LottoStatus_SECOND_PLACE() {
        assertEquals(LottoStatus.SECOND_PLACE, LottoStatus.getLottoStatus(5, true));
    }

    @ParameterizedTest
    @CsvSource(value = { "FIFTH_PLACE:6000", "FOURTH_PLACE:51000", "THIRD_PLACE:1501000",
            "SECOND_PLACE:30001000", "FIRST_PLACE:2000001000" }, delimiter = ':')
    void LottoStatus별_당첨된_누적_금액(LottoStatus status, int expected) {
        assertEquals(expected, status.accumlateByLottoStatus(1000));
    }

    @ParameterizedTest
    @CsvSource(value = { "FIFTH_PLACE:15000", "FOURTH_PLACE:150000", "THIRD_PLACE:4500000",
            "SECOND_PLACE:90000000", "FIRST_PLACE:6000000000" }, delimiter = ':')
    void LottoStatus별_당첨_금액과_LottoStatus_기본_당첨_금액을_나누어_당첨_개수를_구함(LottoStatus status,
            long totalAmount) {
        assertEquals(3, status.countByLottoStatus(totalAmount));
    }
}
