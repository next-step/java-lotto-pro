package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 결과 테스트")
public class LottoResultTest {
    @ParameterizedTest(name = "{index}. {0} 결과 테스트")
    @MethodSource("provideNumbersForLottoResultTest")
    void lottoNumbersTest(String testTitle, LottoNumbers prizeLottoNumbers, LottoNumbers myLottoNumbers, LottoRankingStatus expect) {
        int matchAmount = myLottoNumbers.getMatchCount(prizeLottoNumbers);
        LottoResult lottoResult = new LottoResult(matchAmount);
        LottoRankingStatus lottoRankingStatus = lottoResult.getResultRankingStatus();

        assertThat(lottoRankingStatus).isEqualTo(expect);
    }

    private static Stream<Arguments> provideNumbersForLottoResultTest() {
        LottoNumbers prizeLottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        .collect(Collectors.toSet()));
        return Stream.of(
                Arguments.of(
                        "내 숫자들 6개 다 맞는 경우 ",
                        prizeLottoNumbers,
                        new LottoNumbers(
                                Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                                        .collect(Collectors.toSet())),
                        LottoRankingStatus.MATCH6),
                Arguments.of(
                        "내 숫자들 0개 맞는 경우 ",
                        prizeLottoNumbers,
                        new LottoNumbers(
                                Stream.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                                        new LottoNumber(10), new LottoNumber(10), new LottoNumber(12))
                                        .collect(Collectors.toSet())),
                        LottoRankingStatus.NONE),
                Arguments.of(
                        "내 숫자들 3개만 맞는 경우 ",
                        prizeLottoNumbers,
                        new LottoNumbers(
                                Stream.of(new LottoNumber(1), new LottoNumber(8), new LottoNumber(3),
                                        new LottoNumber(10), new LottoNumber(5), new LottoNumber(12))
                                        .collect(Collectors.toSet())),
                        LottoRankingStatus.MATCH3)
        );
    }
}
