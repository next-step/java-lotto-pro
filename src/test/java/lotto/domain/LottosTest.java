package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottosTest {

    @Test
    @DisplayName("로또 구매 개수 테스트")
    void purchase_lotto_cnt_test() {
        assertThat(new Lottos(new Payment("14000").getPurchasedLottoCnt()).getLottosSize()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 로또와 일치 번호 개수 카운트 테스트")
    void match_number_count_test() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("1,2,3,4,5,6"));
        lottoList.add(new Lotto("1,2,3,11,12,13"));
        lottoList.add(new Lotto("11,12,13,14,15,16"));
        Lottos lottos = new Lottos(lottoList);
        Lotto winLotto = new Lotto("1,2,3,4,5,6");

        assertThat(lottos.getMatchNumCnt(0, winLotto)).isEqualTo(6);
        assertThat(lottos.getMatchNumCnt(1, winLotto)).isEqualTo(3);
        assertThat(lottos.getMatchNumCnt(2, winLotto)).isEqualTo(0);

    }
}
