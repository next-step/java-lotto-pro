package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class PlayerPickStrategyTest {
    @DisplayName("선택번호 목록은 null이 아니어야 한다.")
    @ParameterizedTest(name = ParameterizedTest.DISPLAY_NAME_PLACEHOLDER)
    @NullSource
    void 선택번호_null(final List<LottoNumbers> picks) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerPickStrategy(picks))
                .withMessage("선택번호 목록은 null이 아니어야 합니다.");
    }

    @DisplayName("목록 내에 null이 포함되지 않아야 한다.")
    @Test
    void 목록_내_선택번호_null() {
        final List<LottoNumbers> picks = Arrays.asList(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                null
        );
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PlayerPickStrategy(picks))
                .withMessage("선택번호 목록 내 null이 포함되지 않아야 합니다.");
    }

    @DisplayName("주어진 선택번호 목록 순으로 반환한다.")
    @Test
    void 선택번호_순으로_반환() {
        final List<LottoNumbers> picks = Arrays.asList(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(3, 4, 5, 6, 7, 8)
        );
        final NumberPickStrategy pickStrategy = new PlayerPickStrategy(picks);

        final Stream<LottoNumbers> actual = pickStrategy.pickNumbers(2);

        assertThat(actual).containsExactly(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(3, 4, 5, 6, 7, 8)
        );
    }

    @DisplayName("주어진 선택번호보다 많은 개수를 요구해도 주어진 목록 개수만큼만 반환한다.")
    @Test
    void 목록보다_많은_개수_요구() {
        final int pickingQuantity = 10;
        final List<LottoNumbers> picks = Arrays.asList(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(3, 4, 5, 6, 7, 8)
        );
        final NumberPickStrategy pickStrategy = new PlayerPickStrategy(picks);

        final Stream<LottoNumbers> actual = pickStrategy.pickNumbers(pickingQuantity);

        assertThat(actual).containsExactly(
                new LottoNumbers(1, 2, 3, 4, 5, 6),
                new LottoNumbers(2, 3, 4, 5, 6, 7),
                new LottoNumbers(3, 4, 5, 6, 7, 8)
        );
    }
}