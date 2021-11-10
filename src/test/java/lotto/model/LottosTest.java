package lotto.model;

import lotto.factory.LottoCreateFactory;
import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    private Lottos lottos;

    @DisplayName("갯수를 입력받아 Factory로 로또를 여러개 생성하는 기능 검증")
    @Test
    void createLottosFromFactory() {
        lottos = LottoCreateFactory.createLottos(20);
        assertThat(lottos.size()).isEqualTo(20);
    }

    @DisplayName("로또묶음을 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        assertThat(lottos.size()).isEqualTo(2);

        List<Lotto> lottoGroup = lottos.getLottoGroup();
        assertThat(lottoGroup.toString()).isEqualTo("[[1, 2, 3, 4, 5, 6], [1, 2, 3, 4, 5, 7]]");
    }


    @DisplayName("null, 빈값일때 에러 처리")
    @Test
    void validEmptyTest() {
        assertThatThrownBy(() -> {
            new Lottos(Arrays.asList());
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);

        assertThatThrownBy(() -> {
            new Lottos(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_NULL);
    }
}
