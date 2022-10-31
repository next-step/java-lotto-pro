package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class QuickPickStrategyTest {
    @DisplayName("숫자 생성기는 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 숫자_생성기가_null(RandomNumberGenerator generator) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new QuickPickStrategy(generator))
                .withMessage("숫자 생성기는 null이 아니어야 합니다.");
    }

    @Test
    void 숫자_생성기가_생성한_숫자들로_로또_생성() {
        final QuickPickStrategy strategy = new QuickPickStrategy(() -> Arrays.asList(11, 12, 13, 14, 15, 16));
        final int quantity = 2;
        final List<Lotto> expected = Arrays.asList(
                new Lotto(11, 12, 13, 14, 15, 16),
                new Lotto(11, 12, 13, 14, 15, 16)
        );

        final List<Lotto> actual = strategy.pickNumbers(quantity);
        assertThat(actual).containsExactlyElementsOf(expected);
    }
}
