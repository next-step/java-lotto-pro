package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @Test
    void 당첨로또_생성(){
        WinningLotto winningLotto = WinningLotto.of("1,2,3,4,5,6", 40);

        assertThat(winningLotto).isNotNull();
    }

    @Test
    void 당첨로또_생성_실패_로또번호_보너스번호포함() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> WinningLotto.of("1,2,3,4,5,6",6)
        ).withMessageContaining("당첨번호에 보너스 번호가 포함될 수 없습니다.");
    }

}
