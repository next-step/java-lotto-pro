package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

import lotto.domain.WinningStatistic;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    Lottos lottos;

    @BeforeEach
    void before() {
        lottos = new Lottos();
    }

    @Test
    void 로또_개수를_반환한다() {
        // when
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lottos.add(Lotto.create(numbers));
        // then
        assertThat(lottos.count()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource
    void 당첨_로또를_입력받아_당첨금_통계를_낸다(Lottos lottos, Rank rank) {
        // given
        WinningLotto winning = new WinningLotto("1, 2, 3, 4, 5, 6", "7");
        // when
        WinningStatistic statistic = lottos.checkWinnings(winning);
        // then
        assertThat(statistic.count(rank)).isEqualTo(1);
    }

    static Stream<Arguments> 당첨_로또를_입력받아_당첨금_통계를_낸다() {
        // given
        Lotto one = Lotto.createWithNumberLetter("1, 2, 3, 4, 5, 6");
        Lotto two = Lotto.createWithNumberLetter("1, 2, 3, 4, 5, 7");
        Lotto three = Lotto.createWithNumberLetter("1, 2, 3, 4, 5, 11");

        Lottos first = new Lottos();
        first.add(one);

        Lottos second = new Lottos();
        second.add(two);

        Lottos third = new Lottos();
        third.add(three);
        // when and then
        return Stream.of(
                Arguments.of(first, Rank.FIRST)
                , Arguments.of(second, Rank.SECOND)
                , Arguments.of(third, Rank.THIRD)
        );
    }

}