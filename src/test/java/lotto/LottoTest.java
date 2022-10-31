package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 테스트")
class LottoTest {

    @DisplayName("생성 성공")
    @Test
    void create_lotto_success() {
        assertThatNoException().isThrownBy(() -> new Lotto(new LottoNumberGenerator()));
    }

    @DisplayName("당첨 여부 제공 테스트")
    @Test
    void winningResult_lotto_success() {
        //given:
        Lotto lotto = new Lotto(new LottoNumberBag(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //when:
        LottoNumberBag winningNumbers = new LottoNumberBag(Arrays.asList(1, 2, 3, 10, 20, 30));
        //then:
        assertThat(lotto.getResult(winningNumbers)).isEqualTo(WinningResult.WIN_FOURTH);
    }
}
