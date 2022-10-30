package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
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
    void 로또번호_생성하기(Set<LottoNumber> numbers) {
        assertThatThrownBy(() -> new LottoNumbers(numbers))
            .isInstanceOf(IllegalStateException.class);
    }

    private static Stream<Arguments> 로또번호() {
        return Stream.of(
            Arguments.of(toLottoNumberSet(new int[] {1, 1, 2, 3, 4, 5})),
            Arguments.of(toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6, 7})));
    }

    @ParameterizedTest
    @MethodSource("로또번호_및_당첨번호")
    void 당첨번호와_일치하는_개수_구하기(Set<LottoNumber> lottoNumbers, Set<LottoNumber> winningNumbers, Rank rank,
        LottoNumber bonusNumber) {
        assertThat(new LottoNumbers(lottoNumbers).calculateRank(new LottoNumbers(winningNumbers), bonusNumber))
            .isEqualTo(rank);
    }

    public static Stream<Arguments> 로또번호_및_당첨번호() {
        return Stream.of(
            Arguments.of(//0개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {7, 8, 9, 10, 11, 12}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//1개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 7, 8, 9, 10, 11}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//2개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 7, 8, 9, 10}),
                Rank.MISS, new LottoNumber(45)),
            Arguments.of(//3개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 7, 8, 9}),
                Rank.FIFTH, new LottoNumber(45)),
            Arguments.of(//4개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 7, 8}),
                Rank.FOURTH, new LottoNumber(45)),
            Arguments.of(//5개일치 3등
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 7}),
                Rank.THIRD, new LottoNumber(45)),
            Arguments.of(//5개일치 2등
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 7}),
                Rank.SECOND, new LottoNumber(6)),
            Arguments.of(//6개일치
                toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}), toLottoNumberSet(new int[] {1, 2, 3, 4, 5, 6}),
                Rank.FIRST, new LottoNumber(45))
        );
    }

    private static Set<LottoNumber> toLottoNumberSet(int[] ints) {
        return Arrays.stream(ints).boxed().map(LottoNumber::new).collect(toSet());
    }
}