package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
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
    @DisplayName("정적팩토리 메서드 테스트")
    void newInstance() {
        Lottos lottos = Lottos.newInstance(3, RandomNumberGenerator::generate);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("combine메서드를 통해 Lottos객체 2개가 적절히 합쳐지는지 테스트. 이 때 원본객체의 상태의 변화가 없음도 확인한다.")
    void combine() {
        Lottos original = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 7));
        Lottos extra = new Lottos(new Lotto(7, 8, 9, 10, 11, 12));

        int actualCombinedSize = original.combine(extra).size();
        int actualOriginalSize = original.size();

        assertThat(actualCombinedSize).isEqualTo(3);
        assertThat(actualOriginalSize).isEqualTo(2);
    }

    @Test
    @DisplayName("구매한 복수의 로또와 보너스 번호, 당첨번호가 주어질 때, 적절한 등수(Rank)들을 반환하는지 테스트")
    void computeRanks() {
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 7));
        Collection<Rank> ranks = lottos.computeRanks(Number.of(7), new Lotto(1, 2, 3, 4, 5, 6));
        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND);
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
