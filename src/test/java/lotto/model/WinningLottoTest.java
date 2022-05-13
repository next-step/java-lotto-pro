package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨로또 번호가 1~45 사이가 아닌 경우 검증")
    @Test
    void playLottoGame_not_lotto_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(Arrays.asList(3, 7, 10, 35, 43, 46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto(Arrays.asList(0, 7, 10, 35, 43, 46)))
                .withMessage("[ERROR] 로또 번호는 1~45 사이의 숫자여야합니다.");
    }

    @DisplayName("당첨로또 번호가 6개가 아닌 경우 검증")
    @Test
    void playLottoGame_non_six_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto( Arrays.asList(3, 7, 10, 35)))
                .withMessage("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("당첨로또 6개의 번호에 중복이 있는지 검증")
    @Test
    void playLottoGame_duplication_number() {
        assertThatIllegalArgumentException()
                .isThrownBy(() ->  new WinningLotto( Arrays.asList(3, 7, 10, 10, 25, 35)))
                .withMessage("[ERROR] 6개의 로또 번호에 중복이 있습니다.");
    }

}
