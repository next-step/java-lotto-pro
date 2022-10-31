package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
