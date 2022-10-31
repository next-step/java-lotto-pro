package lotto.prize;

import lotto.status.ErrorStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PrizesTest {

    @Test
    @DisplayName("prize 결과 리스트를 가지고 있는 Prizes 클래스 생성")
    void create_prizes() {
        assertThatCode(() -> new Prizes(Collections.singletonList(Prize.FOURTH))).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("List<Prize>가 null 인경우 IllegalArgumeException발생")
    @NullSource
    void create_prizes_error(List<Prize> nullCase) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Prizes(nullCase))
                .withMessage(ErrorStatus.INVALID_PRIZES.getMessage());
    }

    @ParameterizedTest
    @MethodSource("prizeCountTestCase")
    @DisplayName("매개변수 Prize에 해당 Prize개수 반환")
    void return_prize_match_count(Prizes prizes, Prize prize, int expect) {
        assertThat(prizes.countMatchPrize(prize)).isEqualTo(expect);
    }

    @ParameterizedTest
    @MethodSource("prizeRewardSum")
    @DisplayName("Prize 전체에 대한 총 상금 계산")
    void return_reward(Prizes prizes, BigDecimal expect) {
        assertThat(prizes.sumReward()).isEqualTo(expect);
    }

    private static Stream<Arguments> prizeCountTestCase() {
        return Stream.of(
                Arguments.of(new Prizes(Arrays.asList(Prize.FOURTH, Prize.FOURTH)), Prize.FOURTH, 2),
                Arguments.of(new Prizes(Arrays.asList(Prize.FOURTH, Prize.THIRD)), Prize.FOURTH, 1)
        );
    }

    private static Stream<Arguments> prizeRewardSum() {
        return Stream.of(
                Arguments.of(new Prizes(Arrays.asList(Prize.FOURTH, Prize.FOURTH)), Prize.FOURTH.getPrizeMoney().multiply(new BigDecimal(2))),
                Arguments.of(new Prizes(Arrays.asList(Prize.FOURTH, Prize.THIRD)), Prize.FOURTH.getPrizeMoney().add(Prize.THIRD.getPrizeMoney()))
        );
    }
}
