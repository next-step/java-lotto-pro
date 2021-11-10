package lotto.factory;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.WinningLotto;
import lotto.view.InputHandler;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCreateFactoryTest {

    @DisplayName("숫자를 입력하면 입력한 갯수만큼 로또를 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoCreateFactory.createLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("문자열을 입력받아 당첨 로또를 생성하는 기능 검증")
    @Test
    void createWinningLotto() {
        String text = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        WinningLotto winningLotto = LottoCreateFactory.createWinningLotto(InputHandler.splitTextToInts(text), bonusNumber);

        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)));

    }

}
