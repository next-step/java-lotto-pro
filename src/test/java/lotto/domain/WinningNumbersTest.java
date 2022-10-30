package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {
    @Test
    @DisplayName("로또 당첨 번호를 생성한다 - 보너스 볼 추가")
    void create_winning_number_with_bonus_ball() {
        WinningNumbers winningNumbers = WinningNumbers.of("1, 2, 3, 4, 5, 6", 7);
        assertThat(winningNumbers).isEqualTo(WinningNumbers.of("1, 2, 3, 4, 5, 6", 7));
    }

    @Test
    @DisplayName("보너스 볼은 당첨 번호와 중복되면 안된다")
    void bonus_ball_not_duplicate_winning_number() {
        assertThatThrownBy(() -> WinningNumbers.of("1, 2, 3, 4, 5, 6", 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호는 로또 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("당첨 결과를 반환")
    void check_winning_rank() {
        WinningNumbers winningNumbers = WinningNumbers.of("1, 2, 3, 4, 5, 6", 7);
        LottoNumbers lottoNumbers = LottoNumbers.of(new ManualNumberGenerator("1, 2, 3, 4, 5, 7"));
        assertThat(winningNumbers.checkWinningRank(lottoNumbers)).isEqualTo(WinningRank.SECOND);
    }
}
