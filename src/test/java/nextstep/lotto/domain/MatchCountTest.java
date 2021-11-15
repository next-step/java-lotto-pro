package nextstep.lotto.domain;

import nextstep.lotto.domain.MatchCount.LottoWinningPrice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.lotto.domain.MatchCount.LottoWinningPrice.MATCH_3_COUNT;

public class MatchCountTest {

    @DisplayName("MatchCount 생성자 테스트")
    @ParameterizedTest
    @MethodSource("provide")
    public void matchCountConstructorTest(LottoWinningPrice index, Integer matchCount, MatchCount given) {

        // when
        MatchCount provide = new MatchCount(index, matchCount);

        // then
        Assertions.assertThat(provide).isEqualTo(given);

    }

    public static Stream<Arguments> provide() {
        return Stream.of(
                Arguments.of(MATCH_3_COUNT, 1, new MatchCount(MATCH_3_COUNT, 1))
        );
    }
}
