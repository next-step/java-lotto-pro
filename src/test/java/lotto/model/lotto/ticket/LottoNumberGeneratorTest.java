package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @ParameterizedTest
    @MethodSource("generateTestSources")
    @DisplayName("무작위로 생성한 숫자는 전부 1 부터 45 까지 중에서 하나이다")
    void generate1(List<Integer> numbersCandidate) {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(numbersCandidate);
        final int randomNumber = lottoNumberGenerator.generate();
        assertThat(randomNumber).isGreaterThanOrEqualTo(1);
        assertThat(randomNumber).isLessThanOrEqualTo(45);
        assertThat(numbersCandidate).contains(randomNumber);
    }

    private static Stream<Arguments> generateTestSources() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(1))),
                Arguments.of(new ArrayList<>(Arrays.asList(45))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3))),
                Arguments.of(new ArrayList<>(Arrays.asList(43, 44, 45))),
                Arguments.of(new ArrayList<>(Arrays.asList(10, 20, 30, 40))),
                Arguments.of(new ArrayList<>(Arrays.asList(45, 1, 5, 17, 9, 33)))
        );
    }
}
