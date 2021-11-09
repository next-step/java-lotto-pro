package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumbers;
import step3.domain.WinningLotto;
import step3.domain.constance.LottoConstant;

public class WinningLottoTest {

    @Test
    @DisplayName("우승 번호에 보너스 번호 포함시 예외 발생")
    void valid() {
        assertThatExceptionOfType(InvalidParamException.class)
            .isThrownBy(() -> {
                // when
                WinningLotto.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
            }) // then
            .withMessageMatching(LottoConstant.BONUS_NUMBER_ALREADY_EXIST_MESSAGE);
    }

    @ParameterizedTest
    @MethodSource("getContainCountData")
    @DisplayName("우승번호 일치 카운팅")
    void containCount(List<Integer> winningLottoNumbers, LottoNumbers buyLottoNumbers, int bonusNumber,
        int containCountExpected) {

        // when
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, 45);

        // then
        assertThat(winningLotto.containCount(buyLottoNumbers)).isEqualTo(containCountExpected);
    }

    @Test
    @DisplayName("보너스 일치 여부 체크")
    void bonusMatch_contain() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers buyLottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        // when
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, 7);

        // then
        assertThat(winningLotto.bonusMatch(buyLottoNumbers)).isEqualTo(true);
    }

    @Test
    @DisplayName("보너스 미일치 체크")
    void bonusMatch_not_contain() {
        List<Integer> winningLottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumbers buyLottoNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        // when
        WinningLotto winningLotto = WinningLotto.of(winningLottoNumbers, 45);

        // then
        assertThat(winningLotto.bonusMatch(buyLottoNumbers)).isEqualTo(false);
    }

    private static Stream<Arguments> getContainCountData() {

        return Stream.of(
            Arguments.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                45,
                6
            ),
            Arguments.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
                6,
                5
            ),
            Arguments.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 7)),
                45,
                5
            ),
            Arguments.of(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 8, 7)),
                45,
                4
            )
        );
    }
}
