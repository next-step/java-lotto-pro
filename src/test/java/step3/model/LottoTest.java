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
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto lotto;
    private LottoWinningNumber lottoWinningNumber;

    @BeforeEach
    private void setUp() {
        this.lotto = new Lotto(new LottoNumber(List.of(1, 10, 20, 32, 42, 45)));
        this.lottoWinningNumber = new LottoWinningNumber(new LottoNumber(List.of(1, 11, 20, 24, 40, 42)), 10);
    }

    @Test
    @DisplayName("로또를 생성할때 인자로 널이 들어올경우 에러")
    void givenNull_whenNewLotto_thenThrow() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("행운의번호가 널입니다.");
    }

    @Test
    @DisplayName("로또내에 해당 보너스 숫자가 포함되어 있으면 true 를 리턴")
    void givenNumber_whenIsMatchedBonus_thenTrue() {
        assertThat(lotto.isMatchedBonus(lottoWinningNumber)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,20,32,42,45:6", "1,10,20,30,31,40:3", "2,3,4,5,6,7:0"}, delimiter = ':')
    @DisplayName("구매한 로또에서 당첨번호가 n 개 있으면 n 개를 리턴")
    void givenWinningLotto_whenGetMatchedCount_thenMatchedCount(String text, int expectedMatchedCount) {
        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(new LottoNumber(generateNumbersByText(text)));
        assertThat(this.lotto.getMatchedCount(lottoWinningNumber)).isEqualTo(expectedMatchedCount);
    }

    private List<Integer> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
