package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottosTest {

    @Test
    @DisplayName("로또 목록 생성 테스트")
    void get_lotto_list_test() {
        Lottos lottos = new Lottos();
        lottos.genAutoLotto(10);
        assertThat(lottos.getLottoList()).hasSize(10);
    }

    @Test
    @DisplayName("수동 로또 추가 테스트")
    void add_manual_lotto_test() {
        Lottos lottos = new Lottos();
        lottos.addManualLotto(new Lotto("1,2,3,4,5,6"));
        assertThat(lottos.getLottoList()).hasSize(1);
    }

}
