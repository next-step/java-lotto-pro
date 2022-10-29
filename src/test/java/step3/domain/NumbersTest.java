package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(Lifecycle.PER_CLASS)
public class NumbersTest {

    private final Numbers winning = Numbers.generate(Arrays.asList(1,2,3,4,5,6));

    @ParameterizedTest(name = "{displayName} - select: {0}, countOfMatch: [{1}]")
    @MethodSource("numberProvider")
    @DisplayName("일치하는 번호 개수 확인")
    public void testMatch(List<Integer> selectNumbers, int expected) {
        Numbers select = Numbers.generate(selectNumbers);
        assertThat(winning.match(select)).isEqualTo(expected);
    }

    private Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(Arrays.asList(7,8,9,10,11,12), 0),
                Arguments.of(Arrays.asList(6,7,8,9,10,11), 1),
                Arguments.of(Arrays.asList(5,6,7,8,9,10), 2),
                Arguments.of(Arrays.asList(4,5,6,7,8,9), 3),
                Arguments.of(Arrays.asList(3,4,5,6,7,8), 4),
                Arguments.of(Arrays.asList(2,3,4,5,6,7), 5),
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6)
        );
    }
}