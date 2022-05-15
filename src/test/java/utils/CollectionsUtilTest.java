package utils;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CollectionsUtilTest {

    @ParameterizedTest
    @MethodSource("provideSequentialNumbers")
    @DisplayName("순차적으로 숫자로 채워진 리스트를 반환한다.")
    void sequentialNumbers(int start, int end, List<Integer> result) {
        assertThat(CollectionsUtil.sequentialNumbers(start, end))
                .containsSubsequence(result);

    }

    @ParameterizedTest
    @MethodSource("provideSequentialNumbers")
    @DisplayName("섞인 숫자로 채워진 리스트를 반환한다.")
    void shuffleSequentialNumbers(int start, int end, List<Integer> compare) {
        List<Integer> shuffleSequentialNumbers = CollectionsUtil.shuffleSequentialNumbers(start, end);

        assertThat(shuffleSequentialNumbers.containsAll(compare)).isTrue();
        assertThat(shuffleSequentialNumbers).isNotEqualTo(compare);
    }



    private static Stream<Arguments> provideSequentialNumbers() {
        return Stream.of(
                Arguments.of(0, 3, Arrays.asList(0, 1, 2, 3)),
                Arguments.of(1, 7, Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }




}