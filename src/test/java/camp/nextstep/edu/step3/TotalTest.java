package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalTest {

    @DisplayName("Hit Three 부터 값을 저장하고 있다.")
    @ParameterizedTest
    @MethodSource("provideParametersFromCreateTest")
    void createTest(final Hit[] input, final Hit[] other) {
        assertThat(new Total(input)).isEqualTo(new Total(other));
    }

    private static Stream<Arguments> provideParametersFromCreateTest() {
        return Stream.of(
                Arguments.of(new Hit[]{Hit.ONE, Hit.ALL}, new Hit[]{Hit.ALL}),
                Arguments.of(new Hit[]{Hit.ONE, Hit.TWO, Hit.THREE, Hit.FOUR}, new Hit[]{Hit.THREE, Hit.FOUR})
        );
    }

    @DisplayName("result 메소드 호출시 총 수익률을 반환한다.")
    @Test
    void resultTest() {
        final int userBuyAmount = 14000;
        assertThat(new Total(Hit.ONE, Hit.TWO, Hit.THREE, Hit.FOUR).result(userBuyAmount))
                .isEqualTo(new EarningsRate((Hit.THREE.cost(1) + Hit.FOUR.cost(1)), userBuyAmount));
    }
}
