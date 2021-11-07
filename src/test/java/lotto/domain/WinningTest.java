package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningTest {

    @DisplayName("당첨 결과 통계")
    @Test
    void winningResultTest() {
        //given
        List<Lotto> lotto = new ArrayList<>();

        Lotto winningNumberThreeMatchLotto = Stream.of(1, 2, 3, 11, 22, 33)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
        Lotto winningNumberFourMatchLotto = Stream.of(1, 2, 3, 4, 11, 22)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
        Lotto winningNumberFiveMatchLotto = Stream.of(1, 2, 3, 4, 5, 11)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
        Lotto winningNumberSixMatchLotto = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));

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
    @MethodSource("profitRateParametersProvider")
    void profitRateTest(int purchaseAmount, Rank rank, int winningCount, int profitRate) {
        //given
        Map<Rank, Integer> rankMap = new HashMap<>();
        rankMap.put(rank, winningCount);
        WinningResult winningResult = new WinningResult(rankMap);

        //when
        double profitRateResult = winningResult.profitRate(new Money(purchaseAmount));

        //then
        assertThat(profitRateResult).isEqualTo(profitRate);
    }

    static Stream<Arguments> profitRateParametersProvider() {
        return Stream.of(
                arguments(1000, Rank.FOURTH_PLACE, 1, 5),
                arguments(1000, Rank.THIRD_PLACE, 1, 50),
                arguments(1000, Rank.SECOND_PLACE, 1, 1500),
                arguments(1000, Rank.FIRST_PLACE, 1, 2000000)
        );
    }
}
