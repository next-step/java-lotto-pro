package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoTest {

    @Test
    void 로또_생성() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumberValues()).contains(1, 3, 5, 7, 9, 23);
    }

    @Test
    void 로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumberValues()).hasSize(numbers.length);
    }

    @Test
    void 예외테스트_로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23, 43};

        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_변환() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThat(winningLotto.getNumberValues()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 일치_숫자_확인() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        int[] winningNumbers = {1, 3, 5, 7, 9, 23};
        Lotto winningLotto = new Lotto(winningNumbers);

        int count = lotto.getCount(winningLotto);
        assertThat(count).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource(value = "getRankTestParameter")
    void 당첨_결과_확인_2등_포함(Lotto lotto, WinningLotto winningLotto, Rank rank) {

        assertThat(lotto.getRank(winningLotto)).isEqualTo(rank);
        assertThat(lotto.getRank(winningLotto)).isEqualTo(rank);
    }

    static Stream<Arguments> getRankTestParameter() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(new int[]{1, 2, 3, 4, 5, 6}), new Number(7));

        return Stream.of(
                arguments(new Lotto(new int[]{1, 2, 3, 4, 5, 6}), winningLotto, Rank.FIRST),
                arguments(new Lotto(new int[]{1, 2, 3, 4, 5, 7}), winningLotto, Rank.SECOND),
                arguments(new Lotto(new int[]{1, 2, 3, 4, 5, 8}), winningLotto, Rank.THIRD)
        );
    }

}