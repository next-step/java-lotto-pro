package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.GAME_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoResultTest {

    static Stream<Arguments> listProvide() {
        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7));
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(lottoNumber, matchNumber, Number.of(7)));
    }

    static Stream<Arguments> listProvide3() {
        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7));
        List<Number> lottoNumber2 = Arrays.asList(Number.of(7), Number.of(8), Number.of(9), Number.of(10), Number.of(5), Number.of(7));
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(lottoNumber, lottoNumber2, matchNumber, Number.of(7)));
    }

    static Stream<Arguments> listProvide2() {
        List<Number> lottoNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(7));
        List<Number> matchNumber = Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6));
        return Stream.of(arguments(lottoNumber, matchNumber, Number.of(7)));
    }

    @ParameterizedTest
    @MethodSource("listProvide")
    @DisplayName("로또 수익률 확인")
    public void lottoTest(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(new LottoNumber(lottoNumber)));
        double expected = Rank.SECOND.getPrizeMoney().divide(GAME_PRICE.multiply(BigDecimal.valueOf(1))).doubleValue();

        double actual = lottoMatchResult.getLottoYield();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("listProvide3")
    @DisplayName("로또 수익률 확인")
    public void lottoDifferentTest(List<Number> lottoNumber, List<Number> lottoNumber2, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(new LottoNumber(lottoNumber)));
        LottoResult lottoMatchResult2 = winningLotto.getLottoMatchResult(Arrays.asList(new LottoNumber(lottoNumber2)));

        double actual = lottoMatchResult.getLottoYield();
        double actual2 = lottoMatchResult2.getLottoYield();

        assertThat(actual).isNotEqualTo(actual2);
    }

    @ParameterizedTest
    @MethodSource("listProvide2")
    @DisplayName("로또 번호 보너스 매칭 확인")
    public void activeLottoBonus(List<Number> lottoNumber, List<Number> matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoNumber lotto = new LottoNumber(lottoNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lotto));

        int actualCount = lottoMatchResult.getMatchRankCount(Rank.SECOND);

        assertThat(actualCount).isEqualTo(1);
    }


}
