package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("지난 주 당첨 번호 클래스 테스트")
class WinningNumbersTest {

    private final WinningNumbers tempWinningNumbers = new WinningNumbers("1,2,3,4,5,6");

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "1,2", "1", "1,2,3,4", "1,2,3,4,5" })
    void 입력된_문자열이_로또_숫자_개수인_6개가_아니면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,-", "(,1,2,3,4,5" })
    void 변경할_수_없는_문자열이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string contains characters that cannot be converted to numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "0,1,2,3,4,5", "-1,2,3,4,5" })
    void 음수_또는_0이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void drawLots_결과_검증() {
        List<Lotto> allNumbersFromStore = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 33)),
                new Lotto(Arrays.asList(1, 2, 18, 27, 39, 45)));
        WinStats stats = tempWinningNumbers.drawLots(allNumbersFromStore, new WinStats(2));
        Map<LottoStatus, Long> printData = stats.getPrintDataWithCountsByLottoStatus();

        assertAll(
                () -> assertEquals(1L, printData.get(LottoStatus.SECOND_PLACE)),
                () -> assertEquals("750.00", stats.getPrintDataWithProfitRate())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { 7, 8, 9, 23, 36, 41 })
    void matchNumber_winningNumbers에_포함되지_않은_숫자(int num) {
        assertEquals(0, tempWinningNumbers.matchNumber(num));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    void matchNumber_winningNumbers에_포함된_숫자(int num) {
        assertEquals(1, tempWinningNumbers.matchNumber(num));
    }
}
