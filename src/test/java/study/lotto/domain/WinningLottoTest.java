package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.lotto.domain.number.LottoGenerator;
import study.message.LottoExceptionCode;
import study.message.NumberExceptionCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("지난 주 로또 정보 클래스 테스트")
class WinningLottoTest {

    private final WinningLotto tempWinningLotto = new WinningLotto("1,2,3,4,5,6");

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "1,2", "1", "1,2,3,4", "1,2,3,4,5" })
    void 입력된_문자열이_로또_숫자_개수인_6개가_아니면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.NOT_MATCH_LOTTO_SIZE.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,-", "(,1,2,3,4,5" })
    void 변경할_수_없는_문자열이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NumberExceptionCode.INVALID_NUMBER_STRING.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "0,1,2,3,4,5", "-1,2,3,4,5" })
    void 음수_또는_0이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningLotto(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void drawLots_결과_검증() {
        tempWinningLotto.addBonusBall(7);

        List<Lotto> allNumbersFromStore = new ArrayList<>();
        allNumbersFromStore.add(Store.buyLottoManually("1, 2, 3, 4, 5, 7"));
        allNumbersFromStore.add(Store.buyLottoManually("1, 2, 18, 27, 39, 45"));

        WinStats stats = tempWinningLotto.drawLots(allNumbersFromStore, new WinStats(2));
        Map<LottoStatus, Long> printData = stats.countsByLottoStatus();

        assertAll(
                () -> assertEquals(1L, printData.get(LottoStatus.SECOND_PLACE)),
                () -> assertEquals("15000.00", stats.getProfitRate())
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { 7, 8, 9, 23, 36, 41 })
    void matchNumber_winningNumbers에_포함되지_않은_숫자(int num) {
        assertEquals(0, tempWinningLotto.matchNumber(LottoGenerator.toLottoNumber(num)));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    void matchNumber_winningNumbers에_포함된_숫자(int num) {
        assertEquals(1, tempWinningLotto.matchNumber(LottoGenerator.toLottoNumber(num)));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6 })
    void addBonusBall_winningNumbers에_포함된_숫자가_보너스볼로_입력되는_경우(int num) {
        assertThatThrownBy(() -> {
            tempWinningLotto.addBonusBall(num);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionCode.INVALID_BONUS_BALL.getMessage());
    }

    @ParameterizedTest
    @CsvSource(value = { "7:false", "11:true", "9:false", "23:true", "45:true" }, delimiter = ':')
    void isMatchBonusBall_Lotto가_가지고_있는_숫자_중_bonusBall의_포함_여부(int bonusBall, boolean expected) {
        Lotto lotto = Store.buyLottoManually("1, 2, 3, 11, 23, 45");
        tempWinningLotto.addBonusBall(bonusBall);

        assertEquals(expected, tempWinningLotto.isMatchBonusBall(lotto));
    }
}
