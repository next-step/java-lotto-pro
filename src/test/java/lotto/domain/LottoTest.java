package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또번호가 6개 생성되는지 확인")
    void 로또번호_랜덤생성() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getSize()).isEqualTo(6);
    }

    @Test
    @DisplayName("해당 로또가 얼마가 당첨되는지 확인")
    void 로또번호_결과() {
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        lotto.resultLotto(new Lotto("3,4,5,6"));
        assertThat(lotto.getResult().getReward()).isEqualTo(50000);
    }

}
