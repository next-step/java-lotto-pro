package lotto.domain.lotto.pick;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import lotto.domain.lotto.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class PlayerPickThenQuickPickStrategyTest {
    @DisplayName("수동선택전략은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 수동선택_null(final PlayerPickStrategy playerPick) {
        final QuickPickStrategy quickPick = new QuickPickStrategy(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerPickThenQuickPickStrategy(playerPick, quickPick))
                .withMessage("수동선택전략은 null이 아니어야 합니다.");
    }

    @DisplayName("자동선택전략은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 자동선택_null(final QuickPickStrategy quickPick) {
        final PlayerPickStrategy playerPick = new PlayerPickStrategy(Collections.emptyList());
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerPickThenQuickPickStrategy(playerPick, quickPick))
                .withMessage("자동선택전략은 null이 아니어야 합니다.");
    }

    @Test
    void 수동선택목록_소진_후_자동선택으로_숫자_생성() {
        final PlayerPickStrategy playerPick = new PlayerPickStrategy(
                Arrays.asList(
                        new LottoNumbers(1, 2, 3, 4, 5, 6),
                        new LottoNumbers(2, 3, 4, 5, 6, 7)
                )
        );
        final QuickPickStrategy quickPick = new QuickPickStrategy(
                () -> Arrays.asList(40, 41, 42, 43, 44, 45)
        );
        final PlayerPickThenQuickPickStrategy strategy = new PlayerPickThenQuickPickStrategy(playerPick, quickPick);

        final Stream<LottoNumbers> actual = strategy.pickNumbers(4);

        assertThat(actual).containsExactly(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(40, 41, 42, 43, 44, 45),
                new LottoNumbers(40, 41, 42, 43, 44, 45)
        );
    }
}
