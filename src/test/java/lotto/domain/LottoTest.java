package lotto.domain;

import lotto.constants.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private final List<Integer> winnerNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());

    @ParameterizedTest
    @MethodSource("lottoParam")
    @DisplayName("적중 로또번호 갯수 테스트")
    public void countCollectNumber(int[] givenNumbers, Rank expected) {
        List<Integer> lottoNumbers = Arrays.stream(givenNumbers).boxed().collect(Collectors.toList());
        LottoNumber bonusBall = LottoNumber.of(7);
        Rank rank = Lotto.of(lottoNumbers).countCollectNumber(Lotto.of(winnerNumbers), bonusBall);
        assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> lottoParam() {
        return Stream.of(Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, Rank.FIRST),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 7}, Rank.SECOND),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 8}, Rank.THIRD),
                Arguments.of(new int[]{1, 2, 3, 4, 9, 8}, Rank.FOURTH),
                Arguments.of(new int[]{1, 2, 3, 10, 9, 8}, Rank.FIFTH),
                Arguments.of(new int[]{1, 2, 11, 10, 9, 8}, Rank.MISS)
        );
    }
}
