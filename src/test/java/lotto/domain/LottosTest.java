package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottosTest {

    @Test
    @DisplayName("로또 구매 개수 테스트")
    void purchase_lotto_cnt_test() {
        assertThat(new Lottos(new Payment("14000")).getLottosSize()).isEqualTo(14);
    }

    @Test
    @DisplayName("구입금액에 1000원 미만인 경우 예외처리")
    void payment_less_than_1000_test() {
        assertThatThrownBy(() -> new Lottos(new Payment("400")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또와 일치 번호 개수 카운트 테스트")
    void match_number_count_test() {
        Lottos lottos = new Lottos();
        lottos.addLotto(new Lotto("1,2,3,4,5,6"));
        lottos.addLotto(new Lotto("1,2,3,11,12,13"));
        lottos.addLotto(new Lotto("11,12,13,14,15,16"));
        Lotto winLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lottos.getMatchNumCnt(0, winLotto)).isEqualTo(6);
        assertThat(lottos.getMatchNumCnt(1, winLotto)).isEqualTo(3);
        assertThat(lottos.getMatchNumCnt(2, winLotto)).isEqualTo(0);

    }
}
