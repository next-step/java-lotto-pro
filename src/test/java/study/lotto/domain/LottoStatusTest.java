package study.lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoStatusTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 7, 8, 9})
    void LottoStatus에_존재하지_않는_타입(int result) {
        Assertions.assertEquals(LottoStatus.NONE, LottoStatus.getLottoStatus(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:FOURTH_PLACE", "4:THIRD_PLACE", "5:SECOND_PLACE", "6:FIRST_PLACE"}, delimiter = ':')
    void LottoStatus에_존재하는_타입(int result, LottoStatus expected) {
        assertEquals(expected, LottoStatus.getLottoStatus(result));
    }

    @ParameterizedTest
    @CsvSource(value = { "FOURTH_PLACE:6000", "THIRD_PLACE:51000", "SECOND_PLACE:1501000", "FIRST_PLACE:2000001000" }, delimiter = ':')
    void LottoStatus별_당첨된_누적_금액(LottoStatus status, int expected) {
        assertEquals(expected, status.accumlateByLottoStatus(1000));
    }

    @ParameterizedTest
    @CsvSource(value = { "FOURTH_PLACE:15000", "THIRD_PLACE:150000", "SECOND_PLACE:4500000", "FIRST_PLACE:6000000000" }, delimiter = ':')
    void LottoStatus별_당첨_금액과_LottoStatus_기본_당첨_금액을_나누어_당첨_개수를_구함(LottoStatus status, long totalAmount) {
        assertEquals(3, status.countByLottoStatus(totalAmount));
    }
}
