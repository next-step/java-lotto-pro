package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;

class LottoTest {
    @DisplayName("리스트가 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void null_list_체크(final List<Integer> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers))
                .withMessage("null이 아니어야 합니다.");
    }

    @DisplayName("숫자 6개여야 한다.")
    @Test
    void 숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3)))
                .withMessageContaining("서로 다른 숫자 6개여야 합니다.");
    }

    @DisplayName("서로 다른 숫자 6개여야 한다.")
    @Test
    void 중복없이_숫자_6개() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5)))
                .withMessageContaining("서로 다른 숫자 6개여야 합니다.");
    }

    @DisplayName("숫자는 1에서 45 사이여야 한다.")
    @Test
    void 숫자_범위_유효성() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .withMessageContaining("숫자는 1에서 45 사이여야 합니다.");
    }

    @DisplayName("값이 같으면 동일하다.")
    @Test
    void 동일성() {
        final Lotto one = new Lotto(1, 2, 3, 4, 5, 6);
        final Lotto another = new Lotto(6, 5, 4, 3, 2, 1);

        assertThat(one).isEqualTo(another);
    }

    @DisplayName("당첨 번호는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 당첨_번호_null(final Lotto winningNumbers) {
        final Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 6);
        final LottoNumber bonusNumber = new LottoNumber(7);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> myLotto.match(winningNumbers, bonusNumber))
                .withMessage("당첨 번호는 null이 아니어야 합니다.");
    }

    @DisplayName("보너스 번호는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 보너스_번호_null(final LottoNumber bonusNumber) {
        final Lotto myLotto = new Lotto(1, 2, 3, 4, 5, 6);
        final Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> myLotto.match(winningNumbers, bonusNumber))
                .withMessage("보너스 번호는 null이 아니어야 합니다.");
    }

    @ParameterizedTest(name = "당첨번호 1,2,3,4,5,6이고 보너스 7일 때, 내 로또가 [{0},{1},{2},{3},{4},{5}]이면, [{6}]")
    @CsvSource({
            "1,2,3,4,5,6,SIX",
            "1,2,3,4,5,7,FIVE_WITH_BONUS",
            "1,2,3,4,5,45,FIVE",
            "1,2,3,4,44,45,FOUR",
            "1,2,3,43,44,45,THREE",
            "1,2,42,43,44,45,BLANK",
            "1,41,42,43,44,45,BLANK",
            "40,41,42,43,44,45,BLANK",
    })
    void 당첨_여부(
            final int no1,
            final int no2,
            final int no3,
            final int no4,
            final int no5,
            final int no6,
            final Matches expected
    ) {
        final Lotto myLotto = new Lotto(no1, no2, no3, no4, no5, no6);
        final Lotto winningNumbers = new Lotto(1, 2, 3, 4, 5, 6);
        final LottoNumber bonusNumber = new LottoNumber(7);

        final Matches actual = myLotto.match(winningNumbers, bonusNumber);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("오름차순으로 정렬된 정수 리스트로 변환할 수 있다.")
    @ParameterizedTest(name = "로또: [{0}, {1}, {2}, {3}, {4}, {5}], 정렬된 리스트: [{6}, {7}, {8}, {9}, {10}, {11}]")
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
        final Lotto lotto = new Lotto(
                givenNo1,
                givenNo2,
                givenNo3,
                givenNo4,
                givenNo5,
                givenNo6
        );

        final List<Integer> actual = lotto.toList();

        assertThat(actual).containsExactly(
                expectedNo1,
                expectedNo2,
                expectedNo3,
                expectedNo4,
                expectedNo5,
                expectedNo6
        );
    }
}
