package lotto.domain;

import lotto.exception.BonusNumberDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningTest {

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

    @DisplayName("번호 일치 개수 별 등수")
    @ParameterizedTest
    @MethodSource("rankParametersProvider")
    void rankTest(Lotto lotto, Lotto winningNumber, Rank expectedRank, LottoNumber bonusNumber) {
        //given
        WinningLotto winningLotto = new WinningLotto(winningNumber, bonusNumber);

        //when
        Rank rank = winningLotto.rankResult(lotto);

        //then
        assertThat(rank).isEqualTo(expectedRank);
    }

    static Stream<Arguments> rankParametersProvider() {
        Lotto lotto = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new));

        return Stream.of(
                arguments(lotto, Stream.of(39,40,41,42,43,44)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.LOSER, new LottoNumber(45)),
                arguments(lotto, Stream.of(1,2,3,43,44,45)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.FOURTH_PLACE, new LottoNumber(40)),

                arguments(lotto, Stream.of(1,2,3,4,44,45)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.THIRD_PLACE, new LottoNumber(40)),

                arguments(lotto, Stream.of(1,2,3,4,5,45)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.SECOND_PLACE, new LottoNumber(40)),
                arguments(lotto, Stream.of(1,2,3,4,5,7)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.BONUS_SECOND_PLACE, new LottoNumber(6)),
                arguments(lotto, Stream.of(1,2,3,4,5,6)
                        .map(LottoNumber::new)
                        .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::new)), Rank.FIRST_PLACE, new LottoNumber(45))
        );
    }


}