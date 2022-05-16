package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @Test
    @DisplayName("보너스 번호는 당첨번호와 중복되면 안된다.")
    void bonus_number_duplicate_test() {
        assertThatThrownBy(() -> {
            WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 결과를 반환한다.")
    void match_test() {
        Lotto lotto = new Lotto(LottoNumbers.from("1, 2, 3, 4, 5, 7"));
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6", 7);
        assertThat(winningLotto.match(lotto)).isEqualTo(Rank.SECOND);
    }
}
