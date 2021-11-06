package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningTest {

    static Stream<Arguments> matchCalculationParametersProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 6, 5, 4)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 6, 5)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 7)),
                arguments(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }

    @DisplayName("당첨 번호 일치 계산")
    @ParameterizedTest
    @MethodSource("matchCalculationParametersProvider")
    void matchCalculation(List<Integer> lottoNumber, List<Integer> winningNumber) {
        //given
        Lotto lotto = new Lotto(lottoNumber);

        //when
        int winningNumberMatchResult = lotto.winningNumberMatchCount(winningNumber);

        //then
        assertThat(lotto).isEqualTo(new Lotto(lottoNumber, winningNumberMatchResult));
    }

    @DisplayName("당첨 결과 통계")
    @Test
    void winningResultTest() {
        //given
        List<Lotto> lotto = new ArrayList<>();
        Lotto winningNumberThreeMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 11, 22, 33));
        Lotto winningNumberFourMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 11, 22));
        Lotto winningNumberFiveMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11));
        Lotto winningNumberSixMatchLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        lotto.add(winningNumberThreeMatchLotto);
        lotto.add(winningNumberFourMatchLotto);
        lotto.add(winningNumberFiveMatchLotto);
        lotto.add(winningNumberSixMatchLotto);

        Lottos lottos = new Lottos(lotto);
        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

        //when
        WinningResult winningResult = lottos.winningResult(winningNumber);

        //then
        assertThat(winningResult.winnerPerRank(Rank.FOURTH_PLACE)).isEqualTo(1);
        assertThat(winningResult.winnerPerRank(Rank.THIRD_PLACE)).isEqualTo(1);
        assertThat(winningResult.winnerPerRank(Rank.SECOND_PLACE)).isEqualTo(1);
        assertThat(winningResult.winnerPerRank(Rank.FIRST_PLACE)).isEqualTo(1);
    }

    @DisplayName("번호가 3개 이상 일치해야 당첨")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:true", "4:true", "5:true", "6:true"}, delimiter = ':')
    void isPrizeTest(int winningNumberMatchCount, boolean isPrize) {
        assertThat(Rank.isPrize(winningNumberMatchCount)).isEqualTo(isPrize);
    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @CsvSource(value = {"1000:5000:5", "1000:0:0", "2000:15000:7.5", "5000:5000:1", "10000:5000:0.5"}, delimiter = ':')
    void profitRateTest(int purchaseAmount, int profitAmount, double profitRate) {
        //given
        Lottos lottos = new Lottos(new ArrayList<>());
        WinningResult winningResult = lottos.winningResult(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        double profitRateResult = winningResult.profitRate(purchaseAmount, profitAmount);

        //then
        assertThat(profitRateResult).isEqualTo(profitRate);
    }
}
