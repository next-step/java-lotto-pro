package lotto.model;

import static lotto.model.Lotto.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.model.enums.Rank;

public class LottoTest {
    @ParameterizedTest
    @DisplayName(NUMBER_SIZE + "개의 숫자로 구성되어 있지 않을 경우 예외 발생")
    @MethodSource("provideIllegalNumbers")
    void 객체_생성_시_유효성_검사(int[] numbers) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new Lotto(numbers)
        ).withMessageContaining(NUMBER_SIZE_ERR_MSG);
    }

    private static Stream<int[]> provideIllegalNumbers() {
        return Stream.of(
            new int[] {1, 2, 3, 4, 5},
            new int[] {1, 2, 3, 4, 5, 6, 7}
        );
    }

    @Test
    @DisplayName("생성자의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void createByNull() {
        assertThatNullPointerException().isThrownBy(() ->
            new Lotto((Set<Number>)null)
        );
    }

    @ParameterizedTest
    @DisplayName("보너스 번호와 당첨번호가 주어질 때, 적절한 등수(Rank)가 나오는지를 테스트")
    @MethodSource("provideWinningLottoAndExpectedRank")
    void computeRank(Number bonusNumber, Lotto winningLotto, Rank expectedRank) {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 7);
        Rank actualRank = lotto.computeRank(bonusNumber, winningLotto);
        assertThat(actualRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideWinningLottoAndExpectedRank() {
        return Stream.of(
            Arguments.of(Number.of(7), new Lotto(1, 2, 3, 4, 5, 6), Rank.SECOND),
            Arguments.of(Number.of(8), new Lotto(1, 2, 3, 4, 5, 6), Rank.THIRD)
        );
    }

    @Test
    @DisplayName("로또 번호 내의 숫자 포함여부를 검사하는 contains함수 정상 작동 여부 테스트")
    void contains() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.contains(Number.of(1))).isTrue();
        assertThat(lotto.contains(Number.of(7))).isFalse();
    }

    @Test
    @DisplayName("computeRank() 메서드의 매개변수로 null이 전달될 때 예외를 발생시킨다")
    void computeRankByNull() {
        Number bonusNumber = Number.of(7);
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThatNullPointerException().isThrownBy(() ->
            new Lotto(1, 2, 3, 4, 5, 7).computeRank(null, winningLotto)
        );
        assertThatNullPointerException().isThrownBy(() ->
            new Lotto(1, 2, 3, 4, 5, 7).computeRank(bonusNumber, null)
        );
    }
}
