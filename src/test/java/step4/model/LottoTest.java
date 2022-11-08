package step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.constant.StringConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto lotto;
    private LottoWinningNumbers lottoWinningNumber;

    @BeforeEach
    private void setUp() {
        this.lotto = new Lotto(Stream.of(1, 10, 20, 32, 42, 45)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        this.lottoWinningNumber = new LottoWinningNumbers(new Lotto(Stream.of(1, 11, 20, 24, 40, 42)
                .map(LottoNumber::new)
                .collect(Collectors.toList())), new LottoNumber(10));
    }

    @Test
    @DisplayName("로또를 생성할때 인자로 널이 들어올경우 에러")
    void givenNull_whenNewLotto_thenThrow() {
        assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("행운의번호가 널입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"14,32,41", "10,23,34,40,41,42,43"})
    @DisplayName("로또를 생성할때 6개가 안될경우 에러")
    void givenLessOrExceed_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new Lotto(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("6자리 수");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10,11,11,12,13,14", "20,20,21,22,23,24", "30,31,32,33,34,34"})
    @DisplayName("로또를 생성할때 숫자가 겹치는게 있을경우 에러")
    void givenDuplicated_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new Lotto(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("증복된 숫자");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,2,3,4,5", "40,41,42,43,44,47"})
    @DisplayName("로또를 생성할때 숫자가 로또숫자 범위를 벗어날경우 에러")
    void givenOverOrLessLottoNumber_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new Lotto(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또범위의 숫자");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    @DisplayName("주어진 번호가 로또 번호에 포함된 경우 true 를 리턴")
    void givenNumber_whenContains_thenTrue(int number) {
        assertThat(lotto.contains(new LottoNumber(number))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 11, 15})
    @DisplayName("주어진 번호가 로또 번호에 포함되지 않은 경우 false 를 리턴")
    void givenNumber_whenContains_thenFalse(int number) {
        assertThat(lotto.contains(new LottoNumber(number))).isFalse();
    }

    @Test
    @DisplayName("로또내에 해당 보너스 숫자가 포함되어 있으면 true 를 리턴")
    void givenNumber_whenIsMatchedBonus_thenTrue() {
        assertThat(lottoWinningNumber.isMatchedBonus(lotto)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,20,32,42,45:6", "1,10,20,30,31,40:3", "2,3,4,5,6,7:0"}, delimiter = ':')
    @DisplayName("구매한 로또에서 당첨번호가 n 개 있으면 n 개를 리턴")
    void givenWinningLotto_whenGetMatchedCount_thenMatchedCount(String text, int expectedMatchedCount) {
        LottoWinningNumbers lottoWinningNumber = new LottoWinningNumbers(new Lotto(generateNumbersByText(text)));
        assertThat(lottoWinningNumber.getMatchedCount(lotto)).isEqualTo(expectedMatchedCount);
    }

    private List<LottoNumber> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
