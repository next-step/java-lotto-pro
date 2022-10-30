package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoLotteryTest {
    @Test
    @DisplayName("구매한 복권의 갯수만큼 자동 로또가 생성된다")
    void create() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("3000");
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        LottoLottery lottoLottery = LottoLottery.of(lottoPurchaseQuantity, new AutoNumberGenerator());
        assertThat(lottoLottery).isInstanceOf(LottoLottery.class);
    }

    @Test
    @DisplayName("당첨 결과를 반환")
    void match_winning_rank() {
        LottoLottery lottoLottery = LottoLottery.of(LottoPurchaseQuantity.of(3), new ManualNumberGenerator("1,2,3,4,5,6"));
        assertThat(lottoLottery.matchWinningRank(WinningNumbers.of("1,2,3,8,9,10", 5)))
                .isEqualTo(WinningRanks.of(Arrays.asList(WinningRank.FIFTH, WinningRank.FIFTH, WinningRank.FIFTH)));
    }

    @Test
    @DisplayName("로또 복권 내역")
    void lotto_lottery_history() {
        LottoLottery lottoLottery = LottoLottery.of(LottoPurchaseQuantity.of(3), new ManualNumberGenerator("1,2,3,4,5,6"));
        assertThat(lottoLottery.lotteryHistory()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]");
    }
}
