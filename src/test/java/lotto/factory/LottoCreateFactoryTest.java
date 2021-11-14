package lotto.factory;

import lotto.model.*;
import lotto.view.InputHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCreateFactoryTest {

    @DisplayName("총 로또를 만드는 기능 검증")
    @Test
    void createTotalLottos() {
        LottosCount lottosCount = new LottosCount(4, 2);
        List<String> manualLottoTexts = Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12");

        Lottos lottos = LottoCreateFactory.createTotalLottos(lottosCount, InputHandler.createManualLotto(manualLottoTexts));

        assertThat(lottos.size()).isEqualTo(4);
    }

    @DisplayName("문자열을 입력받아 당첨 로또를 생성하는 기능 검증")
    @Test
    void createWinningLotto() {
        String text = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;
        WinningLotto winningLotto = LottoCreateFactory.createWinningLotto(InputHandler.splitTextToInts(text), bonusNumber);

        assertThat(winningLotto).isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7)));
    }
}
