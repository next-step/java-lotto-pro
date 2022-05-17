package step3.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step3.lotto.domain.Lotto.INVALID_LOTTO_NUMBER_COUNT_ERROR;
import static step3.lotto.domain.Lotto.LOTTO_NUMBER_DUPLICATED_ERROR;
import static step3.lotto.domain.LottoNumber.INVALID_LOTTO_NUMBER_RANGE_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/15 7:39 오후
 */
@DisplayName("Domain:Lotto")
class LottoTest {

    @Test
    @DisplayName("1~45범위의 중복 없는 6개 숫자를 가지는 로또 객체 생성")
    public void createLottoTest() {
        // Given
        final List<Integer> given = Arrays.asList(1, 2, 3, 4, 5, 6);

        // When
        Lotto lotto = Lotto.of(given);

        // Then
        assertAll(
            () -> assertThat(lotto.size()).isEqualTo(given.size())
        );
    }

    @Test
    @DisplayName("6개의 로또 번호를 입력하지 않는 경우 예외")
    public void throwException_WhenGivenNumberIsNotEnoughCount() {
        // Given
        final List<Integer> given = Arrays.asList(1, 2, 3);

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(given))
            .withMessageMatching(INVALID_LOTTO_NUMBER_COUNT_ERROR);
    }

    @Test
    @DisplayName("1~45 범위를 초과하는 숫자가 포함된 로또 객체 생성 시 예외")
    public void throwException_WhenGivenNumberIsInvalidRange() {
        // Given
        final List<Integer> given = Arrays.asList(1, 2, 3, 4, 5, 99);

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(given))
            .withMessageMatching(INVALID_LOTTO_NUMBER_RANGE_ERROR);
    }

    @Test
    @DisplayName("중복된 수를 포함한 로또 객체 생성 시 예외")
    public void throwException_WhenGivenNumberIsDuplicated() {
        // Given
        final List<Integer> given = Arrays.asList(1, 2, 3, 4, 6, 6);

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(given))
            .withMessageMatching(LOTTO_NUMBER_DUPLICATED_ERROR);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiterString = ":")
    @DisplayName("단일 로또 번호 포함 여부 판별")
    public void containsTest(int given, boolean expected) {
        // Given
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When & Then
        assertThat(lotto.contains(LottoNumber.of(given))).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("로또 당첨 번호와 일치하는 갯수 판별")
    public void matchTest(Lotto lotto, Lotto winningLotto, int expected) {
        // When & Then
        assertThat(lotto.matchCount(winningLotto)).isEqualTo(expected);
    }

    private static Stream matchTest() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7)), 5),
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 2, 3, 4, 7, 8)), 4),
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9)), 3),
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 2, 7, 8, 9, 10)), 2),
            Arguments.of(lotto, Lotto.of(Arrays.asList(1, 7, 8, 9, 10, 11)), 1),
            Arguments.of(lotto, Lotto.of(Arrays.asList(7, 8, 9, 10, 11, 12)), 0)
        );
    }
}
