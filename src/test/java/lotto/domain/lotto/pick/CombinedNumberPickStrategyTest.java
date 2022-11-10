package lotto.domain.lotto.pick;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

class CombinedNumberPickStrategyTest {
    @DisplayName("생성 전략은 하나 이상 존재해야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @EmptySource
    void empty(NumberPickStrategy[] strategies) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CombinedNumberPickStrategy(strategies))
                .withMessage("로또 번호 생성 전략은 하나 이상 존재해야 합니다.");
    }

    @DisplayName("생성 전략에 null이 포함되지 않아야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 전략_null(final NumberPickStrategy strategy) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new CombinedNumberPickStrategy(strategy))
                .withMessage("로또 번호 생성 전략은 null이 아니어야 합니다.");
    }

    @Test
    void 전략_순_번호_생성() {
        final NumberPickStrategy first = (__) -> Stream.of(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7)
        );

        final NumberPickStrategy second = (__) -> Stream.of(
                new LottoNumbers(3, 4, 5, 6, 7, 8),
                new LottoNumbers(4, 5, 6, 7, 8, 9)
        );
        final CombinedNumberPickStrategy combinedStrategy = new CombinedNumberPickStrategy(first, second);

        assertThat(combinedStrategy.pickNumbers(3)).containsExactly(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(3, 4, 5, 6, 7, 8)
        );
    }
}
