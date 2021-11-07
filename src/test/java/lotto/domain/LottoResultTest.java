package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoMachine.GAME_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoResultTest {

    static LottoMachine lottoMachine = new LottoMachine();

    static Stream<Arguments> lottoTestData() {
        LottoNumber lottoNumber = lottoMachine.getLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumber matchNumber = lottoMachine.getLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(arguments(lottoNumber, matchNumber, Number.of(7)));
    }

    static Stream<Arguments> lottoDifferentTestData() {
        LottoNumber lottoNumber = lottoMachine.getLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumber lottoNumber2 = lottoMachine.getLottoNumber(Arrays.asList(7, 8, 9, 10, 5, 7));
        LottoNumber matchNumber = lottoMachine.getLottoNumber(Arrays.asList(1,2,3,4,5,6));
        return Stream.of(arguments(lottoNumber, lottoNumber2, matchNumber, Number.of(7)));
    }

    static Stream<Arguments> activeLottoBonusData() {
        LottoNumber lottoNumber = lottoMachine.getLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7));
        LottoNumber matchNumber = lottoMachine.getLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(arguments(lottoNumber, matchNumber, Number.of(7)));
    }

    @ParameterizedTest
    @MethodSource("lottoTestData")
    @DisplayName("로또 수익률 확인")
    public void lottoTest(LottoNumber lottoNumber, LottoNumber matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lottoNumber));
        double expected = Rank.SECOND.getPrizeMoney().getMoney().divide(GAME_PRICE.getMoney().multiply(BigDecimal.valueOf(1))).doubleValue();

        double actual = lottoMatchResult.getLottoYield();

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("lottoDifferentTestData")
    @DisplayName("로또 수익률 확인")
    public void lottoDifferentTest(LottoNumber lottoNumber, LottoNumber lottoNumber2, LottoNumber matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lottoNumber));
        LottoResult lottoMatchResult2 = winningLotto.getLottoMatchResult(Arrays.asList(lottoNumber2));

        double actual = lottoMatchResult.getLottoYield();
        double actual2 = lottoMatchResult2.getLottoYield();

        assertThat(actual).isNotEqualTo(actual2);
    }

    @ParameterizedTest
    @MethodSource("activeLottoBonusData")
    @DisplayName("로또 번호 보너스 매칭 확인")
    public void activeLottoBonus(LottoNumber lottoNumber, LottoNumber matchNumber, Number bonusNumber) {
        WinningLotto winningLotto = new WinningLotto(matchNumber, bonusNumber);
        LottoResult lottoMatchResult = winningLotto.getLottoMatchResult(Arrays.asList(lottoNumber));

        int actualCount = lottoMatchResult.getMatchRankCount(Rank.SECOND);

        assertThat(actualCount).isEqualTo(1);
    }


}
