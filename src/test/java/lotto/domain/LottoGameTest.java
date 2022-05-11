package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("로또 생성하기")
    public void 로또_생성하기() {
        Lotto lotto = LottoGame.generateLotto();
        assertThat(lotto.getLottoNoList()).hasSize(6);
        System.out.println(lotto);
    }
}
