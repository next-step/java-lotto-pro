package step5.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step5.constant.StringConstant;
import step5.model.Lotto;
import step5.model.LottoNo;
import step5.model.LottoWinningNos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoWinningNumberTest {

    private Lotto lotto;
    private LottoWinningNos lottoWinningNumber;

    @BeforeEach
    private void setUp() {
        this.lottoWinningNumber = new LottoWinningNos(new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNo::new)
                .collect(Collectors.toList())), new LottoNo(7));
        this.lotto = new Lotto(Stream.of(1, 2, 3, 4, 5, 7)
                .map(LottoNo::new)
                .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("구입한 로또가 보너스볼이 포함된 로또일경우에 참을 리턴한다.")
    void whenIsBonusVersion_thenTrue() {
        assertThat(this.lottoWinningNumber.isMatchedBonus(lotto)).isTrue();
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 같을 경우 에러를 던진다.")
    void whenWinningNumberEqualsBonusNumber_thenThrow() {
        assertThrows(RuntimeException.class, () -> new LottoWinningNos(new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNo::new)
                .collect(Collectors.toList())), new LottoNo(6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,11,12:4"}, delimiter = ':')
    @DisplayName("구입한 로또가 당첨 로또 번호에 포함된 개수 리턴")
    void givenLottoNumber_whenGetMatchedCount_thenCount(String text, int expectedMatchedCount) {
        Lotto otherLotto = new Lotto(generateNumbersByText(text));
        assertThat(lottoWinningNumber.getMatchedCount(otherLotto)).isEqualTo(expectedMatchedCount);
    }

    private List<LottoNo> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .map(LottoNo::new)
                .collect(Collectors.toList());
    }
}
