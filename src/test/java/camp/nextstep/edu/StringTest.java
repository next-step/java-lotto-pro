package camp.nextstep.edu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("String 의 split 를 이용 하여 분리 작업")
    @ParameterizedTest
    @MethodSource("providerSourceAndExpectedResult")
    void splitTest(final String source, final String[] expectedResult) {
        final String regex = ",";
        assertThat(source.split(regex)).hasSize(expectedResult.length)
                .contains(expectedResult)
                .containsExactly(expectedResult);
    }

    private static Stream<Arguments> providerSourceAndExpectedResult() {
        return Stream.of(
                Arguments.of("1,2", new String[]{"1", "2"}),
                Arguments.of("1", new String[]{"1"})
        );
    }

    @DisplayName("contains 와 containsExactly 차이를 알아 보기 위한 테스트")
    @Test
    void isDifference() {
        final String[] splittingStrArray = "3,4,5".split(",");
        assertThat(splittingStrArray).hasSize(3).contains("4","3","5");
        assertThatExceptionOfType(AssertionError.class)
                .isThrownBy(() -> assertThat(splittingStrArray).containsExactly("4","3","5"));
    }
}
