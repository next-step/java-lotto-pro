package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.step3.Hit.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HitTest {

    @DisplayName("Hit 출력시 일치 갯수와 당청금이 출력된다")
    @ParameterizedTest
    @MethodSource("provideHitAndCountAndPrizeMoney")
    void printTest(final Hit hit, final int count, final int prizeMoney) {
        assertThat(hit.toString()).isEqualTo(expectedMessage(count, prizeMoney));
    }


    @DisplayName("일치한 갯수 값은 0 과 6 사이 값을 가진다.")
    @ParameterizedTest
    @MethodSource("provideHitCountAndExpectedHit")
    void valueOfTest(final int hitCount, Hit expectedHit) {
        assertThat(Hit.valueOf(hitCount)).isEqualTo(expectedHit);
    }

    private static Stream<Arguments> provideHitCountAndExpectedHit() {
        return Stream.of(
                Arguments.of(0, ZERO),
                Arguments.of(6, ALL)
        );
    }

    private String expectedMessage(final int count, final int prizeMoney) {
        return String.format("%d개 일치 (%d원)", count, prizeMoney);
    }

    private static Stream<Arguments> provideHitAndCountAndPrizeMoney() {
        return Stream.of(
                Arguments.of(ZERO, 0, 0),
                Arguments.of(ONE, 1, 0),
                Arguments.of(TWO, 2, 0),
                Arguments.of(THREE, 3, 5000),
                Arguments.of(FOUR, 4, 50000),
                Arguments.of(FIVE, 5, 1500000),
                Arguments.of(ALL, 6, 2000000000)
        );
    }
}
