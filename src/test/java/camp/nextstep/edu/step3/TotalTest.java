package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
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

}
