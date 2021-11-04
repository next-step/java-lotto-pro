package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("당첨 번호를 입력받아 당첨로또 번호 객체 생성하는 기능 검증")
    @Test
    void winningLottoInput() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        assertThat(winningLotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
        assertThat(winningLotto.size()).isEqualTo(LOTTO_SIZE);
    }

    @DisplayName("몇개가 일치 했는지 확인하는 기능 검증")
    @Test
    void winResult() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(new int[]{1,2,3,7,8,9});
        assertThat(winningLotto.matchNumber(lotto)).isEqualTo(3);
    }
}
