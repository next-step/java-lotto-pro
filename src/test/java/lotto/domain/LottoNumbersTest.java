package lotto.domain;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

class LottoNumbersTest {
    @ParameterizedTest
    @NullSource
    @MethodSource("로또번호")
    void 로또번호_생성하기(Set<Integer> numbers) {
        assertThatThrownBy(() -> new LottoNumbers(numbers))
            .isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> 로또번호() {
        return Stream.of(
            Arguments.of(new HashSet<>(asList(1, 1, 2, 3, 4, 5))),
            Arguments.of(new HashSet<>(asList(1, 2, 3, 4, 5, 6, 7))),
            Arguments.of(new HashSet<>(asList(1, 2, 3, 4, 5, 46))),
            Arguments.of(new HashSet<>(asList(1, 2, 3, 4, 5, 0))));
    }

    @ParameterizedTest
    @MethodSource("로또번호_및_당첨번호")
    void 당첨번호와_일치하는_개수_구하기(Set<Integer> lottoNumbers, Set<Integer> winningNumbers, Prize prize) {
        assertThat(new LottoNumbers(lottoNumbers).calculatePrize(new LottoNumbers(winningNumbers)))
            .isEqualTo(prize);
    }

    private static Stream<Arguments> 로또번호_및_당첨번호() {
        return Stream.of(
            Arguments.of(//0개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(7, 8, 9, 10, 11, 12)), Prize.NOTHING),
            Arguments.of(//1개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 7, 8, 9, 10, 11)), Prize.NOTHING),
            Arguments.of(//2개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 7, 8, 9, 10)), Prize.NOTHING),
            Arguments.of(//3개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 7, 8, 9)), Prize.FOURTH),
            Arguments.of(//4개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 7, 8)), Prize.THIRD),
            Arguments.of(//5개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 5, 7)), Prize.SECOND),
            Arguments.of(//6개일치
                new HashSet<>(asList(1, 2, 3, 4, 5, 6)), new HashSet<>(asList(1, 2, 3, 4, 5, 6)), Prize.FIRST)
        );
    }

}