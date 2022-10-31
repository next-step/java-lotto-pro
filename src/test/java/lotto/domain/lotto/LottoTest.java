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

        assertThatIllegalArgumentException()
                .isThrownBy(() -> myLotto.match(winningNumbers))
                .withMessage("당첨 번호는 null이 아니어야 합니다.");
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3,4,5,6,SIX",
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

        final Matches actual = myLotto.match(winningNumbers);

        assertThat(actual).isEqualTo(expected);
    }
}
