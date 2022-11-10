package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class LottoNumbersTest {
    @DisplayName("주어진 숫자들이 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void null_숫자들(final Set<LottoNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers))
                .withMessage("숫자들은 null이 아니어야 합니다.");
    }

    @DisplayName("주어진 숫자들에 null이 포함되지 않아야 한다.")
    @Test
    void null_숫자() {
        final Set<LottoNumber> numbers = new HashSet<>(
                Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        null
                )
        );

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(numbers))
                .withMessageContaining("숫자들에 null이 포함되지 않아야 합니다.");
    }

    @DisplayName("숫자 6개여야 한다.")
    @Test
    void 숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(1, 2, 3))
                .withMessageContaining("서로 다른 숫자 6개여야 합니다.");
    }

    @DisplayName("서로 다른 숫자 6개여야 한다.")
    @Test
    void 중복없이_숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(Arrays.asList(1, 1, 2, 3, 4, 5)))
                .withMessageContaining("서로 다른 숫자 6개여야 합니다.");
    }

    @DisplayName("값이 같으면 동일하다.")
    @Test
    void 동일성() {
        final LottoNumbers one = new LottoNumbers(1, 2, 3, 4, 5, 6);
        final LottoNumbers another = new LottoNumbers(6, 5, 4, 3, 2, 1);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("오름차순으로 정렬된 정수 리스트로 변환할 수 있다.")
    @ParameterizedTest(name = "번호: [{0}, {1}, {2}, {3}, {4}, {5}], 정렬된 리스트: [{6}, {7}, {8}, {9}, {10}, {11}]")
    @CsvSource({
            "6,5,4,3,2,1, 1,2,3,4,5,6",
            "1,45,2,44,3,43, 1,2,3,43,44,45"
    })
    void 정렬된_정수_리스트(
            final int givenNo1,
            final int givenNo2,
            final int givenNo3,
            final int givenNo4,
            final int givenNo5,
            final int givenNo6,
            final int expectedNo1,
            final int expectedNo2,
            final int expectedNo3,
            final int expectedNo4,
            final int expectedNo5,
            final int expectedNo6
    ) {
        final LottoNumbers lotto = new LottoNumbers(
                givenNo1,
                givenNo2,
                givenNo3,
                givenNo4,
                givenNo5,
                givenNo6
        );

        final List<Integer> actual = lotto.toInts();

        assertThat(actual).containsExactly(
                expectedNo1,
                expectedNo2,
                expectedNo3,
                expectedNo4,
                expectedNo5,
                expectedNo6
        );
    }

    @DisplayName("로또 숫자들 두 개끼리 비교하여 겹치는 번호 개수를 셀 수 있다.")
    @ParameterizedTest(name = "번호: [{0}, {1}, {2}, {3}, {4}, {5}], 다른 번호: [{6}, {7}, {8}, {9}, {10}, {11}], 일치 개수: {12}개")
    @CsvSource({
            "1,2,3,4,5,6, 1,2,3,4,5,6, 6",
            "1,2,3,4,5,6, 1,2,3,43,44,45, 3",
            "1,2,3,4,5,6, 11,12,13,14,15,16, 0"
    })
    void 일치하는_개수(
            final int someNo1,
            final int someNo2,
            final int someNo3,
            final int someNo4,
            final int someNo5,
            final int someNo6,
            final int otherNo1,
            final int otherNo2,
            final int otherNo3,
            final int otherNo4,
            final int otherNo5,
            final int otherNo6,
            final long expectedMatchCount
    ) {
        final LottoNumbers someNumbers = new LottoNumbers(
                someNo1,
                someNo2,
                someNo3,
                someNo4,
                someNo5,
                someNo6
        );
        final LottoNumbers otherNumbers = new LottoNumbers(
                otherNo1,
                otherNo2,
                otherNo3,
                otherNo4,
                otherNo5,
                otherNo6
        );

        final long actualMatchCount = someNumbers.countMatchedNumber(otherNumbers);

        assertThat(actualMatchCount).isEqualTo(expectedMatchCount);
    }

    @ParameterizedTest(name = "숫자목록: [1, 2, 3, 4, 5, 6], 주어진 숫자: {0}, 포함 여부: {1}")
    @CsvSource({
            "1, true",
            "45, false"
    })
    void 숫자_포함_여부(final int givenNumber, final boolean expected) {
        final LottoNumber number = new LottoNumber(givenNumber);
        final LottoNumbers numbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}