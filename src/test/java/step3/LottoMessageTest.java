package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMessageTest {

    @Test
    void 시작_문구_테스트() {
        Assertions.assertEquals(LottoMessage.START.getMessage(), "구입금액을 입력해 주세요.");
    }

    @Test
    void 당첨_번호_입력_문구_테스트() {
        Assertions.assertEquals(LottoMessage.WIN_NUMBERS.getMessage(), "지난 주 당첨 번호를 입력해 주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:3개 일치 (5000원)- 1개", "2:3개 일치 (5000원)- 2개", "3:3개 일치 (5000원)- 3개"}, delimiter = ':')
    void 당첨_통계_문구_테스트(int input, String expected) {
        Assertions.assertEquals(expected, LottoMessage.MATCH_THREE.resultMatchNumber(input));
    }

    @Test
    void 총수익률_문구_테스트() {
        Assertions.assertEquals(LottoMessage.STATISTICS_RESULT.resultStatistic(0.35), "총 수익률은 0.35입니다.");
    }
}
