package lotto.factory;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.view.InputHandler;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCreateFactoryTest {
    private final static int LOTTO_SIZE = 6;

    @DisplayName("로또를 자동생성하는 기능 검증")
    @Test
    void lottoCreate() {
        Lotto lotto = LottoCreateFactory.createRandomLotto();
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
    }

    @DisplayName("숫자를 입력하면 입력한 갯수만큼 로또를 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoCreateFactory.createLottos(10);
        assertThat(lottos.size()).isEqualTo(10);
    }

    @DisplayName("문자열을 입력받아 당첨 로또를 생성하는 기능 검증")
    @Test
    void createWinLottos() {
        String text = "1, 2, 3, 4, 5, 6";
        Lotto lotto = LottoCreateFactory.createLotto(InputHandler.splitTextToInts(text));
        assertThat(lotto.size()).isEqualTo(LOTTO_SIZE);
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");

    }

    @DisplayName("입력 받은 숫자 배열이 중복이면 에러가 나오게 하는 기능 검증")
    @Test
    void duplicateError() {
        assertThatThrownBy(() -> {
            Lotto lotto = LottoCreateFactory.createLotto(Arrays.asList(1, 2, 3, 1, 2, 3));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_ERROR);
    }
}
