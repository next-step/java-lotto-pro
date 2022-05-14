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
        assertThat(round.isPaying()).isTrue();
    }

    @Test
    @DisplayName("null 객체로 생성시 오류 확인")
    void start_실패_null() {
        // when & then
        assertThatThrownBy(() -> Round.start(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("회차 종료가 잘 되는 지 확인")
    void end() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));

        // when
        round.end(lottoNumbers(1, 2, 3, 4, 5, 6));

        // then
        assertThat(round.isEnd()).isTrue();
    }

    @Test
    @DisplayName("회차 종료시 null 전달시 오류 확인")
    void end_실패_null() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));

        // when & then
        assertThatThrownBy(() -> round.end(null))
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

    @Test
    @DisplayName("수익률 계산 반환")
    void totalReturnRate() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));
        round.end(lottoNumbers(1, 2, 3, 4, 5, 6));

        // when & then
        assertThat(round.totalReturnRate()).isEqualTo(Rate.valueOf(2000000.0));
    }

    @Test
    @DisplayName("완료 되지 않은 상태에서 수익률 계산 요청")
    void totalReturnRate_실패() {
        // given
        final Round round = Round.start(lottos(lotto(1, 2, 3, 4, 5, 6)));

        // when & then
        assertThatThrownBy(round::totalReturnRate)
                .isInstanceOf(IllegalStateException.class);

    }

}