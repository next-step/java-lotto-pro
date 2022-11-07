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

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    private void setUp() {
        this.lottoNumber = new LottoNumber(List.of(1, 10, 20, 32, 42, 45));
    }

    @Test
    @DisplayName("로또를 생성할때 인자로 널이 들어올경우 에러")
    void givenNull_whenNewLotto_thenThrow() {
        assertThatThrownBy(() -> new LottoNumber(null))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("행운의번호가 널입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"14,32,41", "10,23,34,40,41,42,43"})
    @DisplayName("로또를 생성할때 6개가 안될경우 에러")
    void givenLessOrExceed_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new LottoNumber(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("6자리 수");
    }

    @ParameterizedTest
    @ValueSource(strings = {"10,11,11,12,13,14", "20,20,21,22,23,24", "30,31,32,33,34,34"})
    @DisplayName("로또를 생성할때 숫자가 겹치는게 있을경우 에러")
    void givenDuplicated_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new LottoNumber(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("증복된 숫자");
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,1,2,3,4,5", "40,41,42,43,44,47"})
    @DisplayName("로또를 생성할때 숫자가 로또숫자 범위를 벗어날경우 에러")
    void givenOverOrLessLottoNumber_whenNewLotto_thenThrow(String text) {
        assertThatThrownBy(() -> new LottoNumber(generateNumbersByText(text)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또범위의 숫자");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 20})
    @DisplayName("주어진 번호가 로또 번호에 포함된 경우 true 를 리턴")
    void givenNumber_whenContains_thenTrue(int number) {
        assertThat(lottoNumber.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 11, 15})
    @DisplayName("주어진 번호가 로또 번호에 포함되지 않은 경우 false 를 리턴")
    void givenNumber_whenContains_thenFalse(int number) {
        assertThat(lottoNumber.contains(number)).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,10,20,33,34,44:3", "1,10,20,32,42,45:6"}, delimiter = ':')
    @DisplayName("구입한 로또가 당첨 로또 번호에 포함된 개수 리턴")
    void givenLottoNumber_whenGetMatchedCount_thenCount(String text, int expectedMatchedCount) {
        LottoNumber otherLottoNumber = new LottoNumber(generateNumbersByText(text));
        assertThat(lottoNumber.getMatchedCount(otherLottoNumber)).isEqualTo(expectedMatchedCount);
    }

    private List<Integer> generateNumbersByText(String text) {
        return Arrays.stream(text.split(StringConstant.COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
