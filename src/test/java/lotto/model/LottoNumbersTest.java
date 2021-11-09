package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void instantiate_6개_성공() {
        final List<LottoNumber> lottoNumberList = generateLottoNumberListOf(6);
        final LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
        assertThat(lottoNumbers).isNotNull();
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 10})
    void instantiate_실패(int count) {
        final List<LottoNumber> lottoNumberList = generateLottoNumberListOf(count);
        assertThatThrownBy(() -> new LottoNumbers(lottoNumberList))
                .isInstanceOf(RuntimeException.class);
    }

    private List<LottoNumber> generateLottoNumberListOf(int count) {
        final List<LottoNumber> lottoNumberList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            lottoNumberList.add(new LottoNumber(i));
        }
        return lottoNumberList;
    }

    @ParameterizedTest
    @MethodSource("provideWinNumbers")
    void calculateNumberOfMatch(LottoNumbers winNumbers, int expectedNumberOfMatch) {
        final LottoNumbers buyNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(buyNumbers.calculateNumberOfMatch(winNumbers))
                .isEqualTo(expectedNumberOfMatch);
    }

    private static Stream<Arguments> provideWinNumbers() {
        return Stream.of(
                Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(LottoNumbers.of(Arrays.asList(11, 12, 13, 14, 15, 16)), 0),
                Arguments.of(LottoNumbers.of(Arrays.asList(1, 2, 13, 14, 15, 16)), 2)
        );
    }
}
