package lotto.lotto;

import lotto.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("WinningLotto 클래스 테스트")
class WinningLottoTest {

    @DisplayName("생성시 보너스 번호가 당청번호와 겹쳐 예외 발생")
    @Test
    void failureWinningLotto() {
        assertThatThrownBy(() -> {
            new WinningLotto(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.of(1));
        })
        .isInstanceOf(AlreadyExistsBonusLottoNumberException.class)
        .hasMessageContaining("보너스 번호가 당첨 번호에 존재합니다.");
    }

    @DisplayName("Lotto 확인하여 LottoPrize를 반환")
    @ParameterizedTest
    @ArgumentsSource(GuessArgumentsProvider.class)
    void guess(Lotto lotto, LottoPrize lottoPrize) {
        final WinningLotto winningLotto = WinningLotto.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoNumber.of(45));
        assertThat(winningLotto.guess(lotto)).isEqualTo(lottoPrize);
    }

    static class GuessArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(Lotto.of(1, 2, 3, 4, 5, 6), LottoPrize.SIX_MATCH),
                    Arguments.of(Lotto.of(1, 2, 3, 4, 5, 45), LottoPrize.FIVE_MATCH_WITH_BONUS),
                    Arguments.of(Lotto.of(1, 2, 3, 4, 5, 7), LottoPrize.FIVE_MATCH),
                    Arguments.of(Lotto.of(1, 2, 3, 4, 7, 8), LottoPrize.FOUR_MATCH),
                    Arguments.of(Lotto.of(1, 2, 3, 7, 8, 9), LottoPrize.THREE_MATCH),
                    Arguments.of(Lotto.of(1, 2, 7, 8, 9, 10), LottoPrize.MISS),
                    Arguments.of(Lotto.of(1, 7, 8, 9, 10, 11), LottoPrize.MISS),
                    Arguments.of(Lotto.of(7, 8, 9, 10, 11, 12), LottoPrize.MISS)
            );
        }
    }
}
