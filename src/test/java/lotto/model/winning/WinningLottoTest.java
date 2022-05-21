package lotto.model.winning;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 생성_테스트() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertEquals(winningLotto, new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    @DisplayName("당첨번호와 보너스볼이 중복된다면 에러")
    void 당첨번호와_보너스볼의_중복체크() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3), 3));
    }

}
