package lotto.domain.lotto.pick;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
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
        final List<LottoNumbers> expected = Arrays.asList(
                new LottoNumbers(11, 12, 13, 14, 15, 16),
                new LottoNumbers(11, 12, 13, 14, 15, 16)
        );

        final Stream<LottoNumbers> actual = strategy.pickNumbers(quantity);
        Assertions.assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    void 로또_길이와_다른_숫자가_생성() {
        final QuickPickStrategy strategy = new QuickPickStrategy(() -> Arrays.asList(1, 2, 3));
        final int quantity = 1;

        assertThatIllegalStateException()
                .isThrownBy(() -> strategy.pickNumbers(quantity).collect(Collectors.toList()))
                .withMessageMatching("생성된 숫자의 길이가 \\d+이어야 합니다. elements=.+");
    }
}
