package lotto.domain;

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
    void lottoNumbersTest(String testTitle,
                          LottoNumbers prizeLottoNumbers,
                          LottoNumbers myLottoNumbers,
                          LottoRankingStatus expect,
                          LottoNumber bonusLottoNumber) {
        int matchAmount = myLottoNumbers.getMatchCount(prizeLottoNumbers);
        boolean matchBonus = myLottoNumbers.containsNumber(bonusLottoNumber);
        LottoResult lottoResult = new LottoResult(matchAmount, matchBonus);
        LottoRankingStatus lottoRankingStatus = lottoResult.getResultRankingStatus();

        assertThat(lottoRankingStatus).isEqualTo(expect);
    }

    private static Stream<Arguments> provideNumbersForLottoResultTest() {
        LottoNumbers prizeLottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        .collect(Collectors.toSet()));
        LottoNumbers matchNoneLottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                        new LottoNumber(10), new LottoNumber(10), new LottoNumber(12))
                        .collect(Collectors.toSet()));
        LottoNumbers match3LottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(1), new LottoNumber(8), new LottoNumber(3),
                        new LottoNumber(10), new LottoNumber(5), new LottoNumber(12))
                        .collect(Collectors.toSet()));
        LottoNumbers match5LottoNumbers = new LottoNumbers(
                Stream.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))
                        .collect(Collectors.toSet()));
        LottoNumber notMatchBonusLottoNumber = new LottoNumber(44);
        LottoNumber matchBonusLottoNumber = new LottoNumber(6);
        return Stream.of(
                Arguments.of(
                        "내 숫자들 6개 다 맞는 경우 ",
                        prizeLottoNumbers,
                        prizeLottoNumbers,
                        LottoRankingStatus.MATCH6,
                        notMatchBonusLottoNumber),
                Arguments.of(
                        "내 숫자들 0개 맞는 경우 ",
                        prizeLottoNumbers,
                        matchNoneLottoNumbers,
                        LottoRankingStatus.NONE,
                        notMatchBonusLottoNumber),
                Arguments.of("내 숫자들 3개만 맞는 경우 ", prizeLottoNumbers,
                        match3LottoNumbers,
                        LottoRankingStatus.MATCH3,
                        notMatchBonusLottoNumber),
                Arguments.of("내 숫자들 5개, 보너스 1개 맞는 경우 ", prizeLottoNumbers,
                        match5LottoNumbers,
                        LottoRankingStatus.MATCH5BONUS1,
                        matchBonusLottoNumber)
        );
    }
}
