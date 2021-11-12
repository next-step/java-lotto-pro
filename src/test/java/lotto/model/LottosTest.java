package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.enums.Rank;

public class LottosTest {
    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new Lottos((Collection<Lotto>)null)
        );
    }

    @Test
    @DisplayName("구매한 복수의 로또와 보너스 번호, 당첨번호가 주어질 때, 적절한 등수(Rank)들을 반환하는지 테스트")
    void computeRanks() {
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 7));
        Lottos extraLottos = new Lottos(new Lotto(7, 8, 9, 10, 11, 12));
        lottos.addAll(extraLottos);

        Collection<Rank> ranks = lottos.computeRanks(Number.of(7), new Lotto(1, 2, 3, 4, 5, 6));

        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.MISS);
    }

    @ParameterizedTest
    @DisplayName("메서드의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    @MethodSource("provideNullParameter")
    void computeRanksByNull(Number bonusNumber, Lotto winningLotto) {
        assertThatNullPointerException().isThrownBy(() ->
            new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 7))
                .computeRanks(bonusNumber, winningLotto)
        );
    }

    private static Stream<Arguments> provideNullParameter() {
        return Stream.of(
            Arguments.of(null, new Lotto(1, 2, 3, 4, 5, 6)),
            Arguments.of(Number.of(7), null)
        );
    }
}
