package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.LottoNumberTest.makeLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("로또 번호 목록 테스트")
class LottoNumberBagTest {

    @DisplayName("생성 성공")
    @Test
    void create_bag_success() {
        assertThatNoException().isThrownBy(() -> new LottoNumberBag(new LottoNumberGenerator()));
    }

    @DisplayName("당첨 번호 일치 카운트 제공")
    @Test
    void contains_number_success() {
        //given:
        LottoNumberBag lottoNumberBag = new LottoNumberBag(
                makeLottoNumbers(Arrays.asList("1", "2", "3", "10", "20", "30")));
        WinningLottoBallBag winningNumbers = new WinningLottoBallBag("1,2,3,4,5,6");
        //when:
        Score correctCount = lottoNumberBag.matchScore(winningNumbers);
        //then:
        assertThat(correctCount).isEqualTo(Score.of(3));
    }

    @ParameterizedTest(name = "생성 예외 테스트 - " + DEFAULT_DISPLAY_NAME)
    @MethodSource("provideExceptionValues")
    void validRange_bag_IllegalArgumentException(List<Number> lottoNumbers) {
        //given:
        LottoNumberBag lottoNumberBag = new LottoNumberBag(lottoNumbers);
        //when, then//
        assertThatIllegalArgumentException().isThrownBy(lottoNumberBag::getNumbers);
    }

    static Stream<Arguments> provideExceptionValues() {
        return Stream.of(
                /* 로또 숫자 갯수 불일치 */
                Arguments.of(makeLottoNumbers(Arrays.asList("1", "2", "3", "10", "20", "30", "7"))),
                /* 중복 된 로또 숫자 */
                Arguments.of(makeLottoNumbers(Arrays.asList("1", "1", "3", "10", "20", "30"))),
                /* 로또 숫자 범위를 벗어난 숫자 */
                Arguments.of(makeLottoNumbers(Arrays.asList("1", "2", "3", "10", "20", "99")))
        );
    }
}
