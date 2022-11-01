package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.constant.StringConstant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    private void setUp() {
        this.lotto = new Lotto(Arrays.asList(1,10,20,32,42,45));
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

    private List<Integer> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20, 32})
    @DisplayName("로또내에 해당 숫자가 포함되어있지않으면 true 를 리턴")
    void givenNumber_whenContains_thenTrue(int number) {
        assertThat(lotto.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 30, 40, 41})
    @DisplayName("로또내에 해당 숫자가 포함되어있지않으면 false 를 리턴")
    void givenNumber_whenContains_thenFalse(int number) {
        assertThat(lotto.contains(number)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,20,32,42,45:6", "1,10,20,30,31,40:3", "2,3,4,5,6,7:0"}, delimiter = ':')
    @DisplayName("구매한 로또에서 당첨번호가 n 개 있으면 n 개를 리턴")
    void givenWinningLotto_whenGetMatchedCount_thenMatchedCount(String text, int expectedMatchedCount) {
        Lotto winningLotto = new Lotto(generateNumbersByText(text));
        assertThat(this.lotto.getMatchedCount(winningLotto)).isEqualTo(expectedMatchedCount);
    }
}