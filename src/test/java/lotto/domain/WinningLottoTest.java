package lotto.domain;

import lotto.exception.InputDataErrorCode;
import lotto.exception.InputDataException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("로또 6개 중에 보너스 번호 1개가 중복되는지 확인")
    void match() {
        WinningLotto winningLotto = new WinningLotto(makeLottoBall(Arrays.asList(1, 2, 3, 4, 5, 6)), new Ball(7));
        Lotto compareLotto = makeLottoBall(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertAll(
                () -> assertThat(winningLotto.match(compareLotto)).isEqualTo(6),
                () -> assertThat(winningLotto.bonusBall()).isEqualTo(new Ball(7))
        );
    }

    @Test
    @DisplayName("로또 6개 중에 보너스 번호 1개가 중복되는지 확인")
    void DuplicateBonusNumberInWinningLottoTest() {
        assertThatExceptionOfType(InputDataException.class)
                .isThrownBy(() -> {
                    new WinningLotto(makeLottoBall(Arrays.asList(1, 2, 3, 4, 5, 6)), new Ball(6));
                }).withMessageContaining(InputDataErrorCode.DUPLICATE_BONUS_NUMBER_IN_WINNING_LOTTO_NUMBER.errorMessage());
    }

    private Lotto makeLottoBall(List<Integer> balls) {
        List<Ball> ballBasket = balls.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        return new Lotto(ballBasket);
    }
}
