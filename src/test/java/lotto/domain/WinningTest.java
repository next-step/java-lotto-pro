package lotto.domain;

import lotto.exception.BonusNumberDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningTest {

    @DisplayName("당첨 결과 통계")
    @ParameterizedTest
    @MethodSource("winningResultParametersProvider")
    void winningResultTest(Lotto lotto, LottoNumber bonusNumber, Rank rank) {
        //given
        Lottos lottos = Stream.of(lotto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
        Lotto verifiedWinningNumber = Stream.of(1,2,3,4,5,6)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));
        WinningLotto winningLotto = new WinningLotto(verifiedWinningNumber, bonusNumber);

        //when
        WinningResult winningResult = lottos.winningResult(winningLotto);

        //then
        assertThat(winningResult.winnerPerRank(rank)).isEqualTo(1);
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

    @DisplayName("보너스 번호가 당첨 번호에 존재할 때 예외")
    @Test
    void duplicateWinningNumberAndBonusNumberExceptionTest() {
        //given
        Lotto winningNumber = Stream.of(1,2,3,4,5,45)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));

        LottoNumber bonusNumber = new LottoNumber(45);

        //when and then
        assertThatThrownBy( () -> {
            new WinningLotto(winningNumber, bonusNumber);
        }).isInstanceOf(BonusNumberDuplicateException.class);
    }

    static Stream<Arguments> profitRateParametersProvider() {
        return Stream.of(
                arguments(1000, Rank.FOURTH_PLACE, 1, 5),
                arguments(1000, Rank.THIRD_PLACE, 1, 50),
                arguments(1000, Rank.SECOND_PLACE, 1, 1_500),
                arguments(1000, Rank.BONUS_SECOND_PLACE, 1, 30_000),
                arguments(1000, Rank.FIRST_PLACE, 1, 2_000_000)
        );
    }

    static Stream<Arguments> winningResultParametersProvider() {
        LottoNumber bonusNumber = new LottoNumber(45);

        return Stream.of(
                arguments(Stream.of(1, 2, 3, 11, 22, 33)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), bonusNumber, Rank.FOURTH_PLACE),
                arguments(Stream.of(1, 2, 3, 4, 11, 22)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), bonusNumber, Rank.THIRD_PLACE),
                arguments(Stream.of(1, 2, 3, 4, 5, 11)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), bonusNumber, Rank.SECOND_PLACE),
                arguments(Stream.of(1, 2, 3, 4, 5, 45)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), bonusNumber, Rank.BONUS_SECOND_PLACE),
                arguments(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), bonusNumber, Rank.FIRST_PLACE)
        );
    }
}