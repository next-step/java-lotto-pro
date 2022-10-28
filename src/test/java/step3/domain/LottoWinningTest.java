package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningTest {

    @ParameterizedTest
    @MethodSource("getWinningNumberAndBounusNumber")
    @DisplayName("당첨번호에 중복되는 보너스 번호가 입력될 경우 에러가 발생해야 한다")
    void throwExceptionWhenDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        // given
        Lotto winningLotto = Lotto.of(winningNumbers);

        // when && then
        assertThatThrownBy(() -> LottoWinning.of(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("getLottoAndLottoWinning")
    @DisplayName("로또와 당첨 로또를 비교하여 일치한 숫자 카운팅이 반환되어야 한다")
    void getLottoMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, int expectedCount) {
        // given
        Lotto lotto = Lotto.of(lottoNumbers);
        Lotto winningLotto = Lotto.of(winningNumbers);
        LottoWinning lottoWinning = LottoWinning.of(winningLotto, bonusNumber);

        // when
        long lottoMatchCount = lottoWinning.getLottoMatchCount(lotto);

        // then
        assertThat(lottoMatchCount).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @MethodSource("getLottoAndBonusNumber")
    @DisplayName("로또와 보너스 번호를 비교하여, 보너스 번호의 일치 여부를 확인해야 한다")
    void matchBonusNumberBy(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, boolean matchBonus) {
        // given
        Lotto lotto = Lotto.of(lottoNumbers);
        Lotto winningLotto = Lotto.of(winningNumbers);
        LottoWinning lottoWinning = LottoWinning.of(winningLotto, bonusNumber);

        // when
        boolean match = lottoWinning.matchBonusNumberBy(lotto);

        // then
        assertThat(match).isEqualTo(matchBonus);
    }

    private static Stream<Arguments> getWinningNumberAndBounusNumber() {

        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), 6, 6),
                Arguments.of( Arrays.asList(3,6,8,12,15,18), 8),
                Arguments.of(Arrays.asList(3,6,9,12,15,18), 9)
        );
    }
    private static Stream<Arguments> getLottoAndLottoWinning() {

        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 7, 6),
                Arguments.of(Arrays.asList(1,3,6,9,12,15), Arrays.asList(3,6,8,12,15,18), 1, 4),
                Arguments.of(Arrays.asList(1,3,6,9,12,15), Arrays.asList(3,6,9,12,15,18), 21, 5)
        );
    }

    private static Stream<Arguments> getLottoAndBonusNumber() {

        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6), Arrays.asList(1,2,3,4,5,6), 7, false),
                Arguments.of(Arrays.asList(1,3,6,9,12,15), Arrays.asList(3,6,8,12,15,18), 9, true),
                Arguments.of(Arrays.asList(1,3,6,9,12,15), Arrays.asList(3,6,9,12,15,18), 5, false)
        );
    }
}
