package lotto.domain;

import lotto.exception.WrongLottoNumbersInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 숫자들 테스트")
public class LottoNumbersTest {

    private LottoNumbers expectLottoNumbers;

    @BeforeEach
    void setup() {
        expectLottoNumbers = Fixture.lottoNumbersOf(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 로또 입력 테스트 커스텀 구분자")
    @Test
    void generateManualWithSeparatorNumbers() {
        String prizeLottoNumbersString = "1:2:3:4:5:6";
        String separator = ":";
        LottoNumbers lottoNumbers = new LottoNumbers(prizeLottoNumbersString, separator);
        assertThat(lottoNumbers).isEqualTo(expectLottoNumbers);
    }

    @DisplayName("내 숫자가 정답 숫자를 포함하는 지 테스트")
    @Test
    void matchNumberTest() {
        LottoNumber myLottoNumber = new LottoNumber(1);
        assertThat(expectLottoNumbers.containsNumber(myLottoNumber)).isTrue();
    }

    @ParameterizedTest(name = "{index}. {0} 숫자들 테스트")
    @MethodSource("provideNumbersForLottoNumbersTest")
    void lottoNumbersTest(String testTitle, LottoNumbers prizeLottoNumbers, LottoNumbers myLottoNumbers, int expect) {
        assertThat(myLottoNumbers.getMatchCount(prizeLottoNumbers)).isEqualTo(expect);
    }

    private static Stream<Arguments> provideNumbersForLottoNumbersTest() {
        LottoNumbers exampleLottoNumbers = Fixture.lottoNumbersOf(1, 2, 3, 4, 5, 6);
        LottoNumbers matchNoneLottoNumbers = Fixture.lottoNumbersOf(7, 8, 9, 10, 11, 12);
        LottoNumbers match3LottoNumbers = Fixture.lottoNumbersOf(1, 8, 3, 10, 5, 12);

        return Stream.of(
                Arguments.of("내 숫자들 6개 다 맞는 경우 ", exampleLottoNumbers, exampleLottoNumbers, 6),
                Arguments.of("내 숫자들 0개 맞는 경우 ", exampleLottoNumbers, matchNoneLottoNumbers, 0),
                Arguments.of("내 숫자들 3개만 맞는 경우 ", exampleLottoNumbers, match3LottoNumbers, 3)
        );
    }

    @ParameterizedTest(name = "null 수동 입력 시 오류 테스트")
    @CsvSource(value = {"null abc", "abc null", "null null"},
            nullValues = "null",
            delimiterString = " ")
    void generateManualNullInputNumbersException(String examLottoNumbers, String separator) {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(examLottoNumbers, separator);
        }).isInstanceOf(WrongLottoNumbersInputException.class)
        .hasMessageContaining("수동 입력 로또 번호를 확인해 주세요.");
    }

}
