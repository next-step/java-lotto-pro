package lotto;

import static lotto.LottoTestUtils.lotto;
import static lotto.LottoTestUtils.lottoNumbers;
import static lotto.LottoTestUtils.lottos;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import generic.Rate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

    @Test
    @DisplayName("회차 생성하여 로또 1개 구매 하였는지 확인")
    void start() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));

        // when & then
        assertThat(round.lottos().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("null 객체로 생성시 오류 확인")
    void start_실패_null() {
        // when & then
        assertThatThrownBy(() -> Round.start(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("구매한 로또 갯수 확인")
    void purchaseSize() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));

        // when & then
        assertThat(round.purchaseSize()).isEqualTo(1);
    }

}