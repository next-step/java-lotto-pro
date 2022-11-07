package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.constant.StringConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoWinningNumberTest {

    private Lotto lotto;
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    private void setUp() {
        this.lottoWinningNumber = new LottoWinningNumber(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), 7);
        this.lotto = new Lotto(new LottoNumber(List.of(1, 2, 3, 4, 5, 7)));
    }

    @Test
    @DisplayName("구입한 로또가 보너스볼이 포함된 로또일경우에 참을 리턴한다.")
    void whenIsBonusVersion_thenTrue() {
        assertThat(this.lotto.isMatchedBonus(lottoWinningNumber)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 같을 경우 에러를 던진다.")
    void whenWinningNumberEqualsBonusNumber_thenThrow() {
        assertThrows(RuntimeException.class, () -> new LottoWinningNumber(new LottoNumber(List.of(1, 2, 3, 4, 5, 6)), 6));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,11,12:4"}, delimiter = ':')
    @DisplayName("구입한 로또가 당첨 로또 번호에 포함된 개수 리턴")
    void givenLottoNumber_whenGetMatchedCount_thenCount(String text, int expectedMatchedCount) {
        LottoNumber otherLottoNumber = new LottoNumber(generateNumbersByText(text));
        assertThat(lottoWinningNumber.getMatchedCount(otherLottoNumber)).isEqualTo(expectedMatchedCount);
    }

    private List<Integer> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
