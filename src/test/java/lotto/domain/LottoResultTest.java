package lotto.domain;

import lotto.domain.error.LottoCountErrorCode;
import lotto.domain.error.LottoWinningResultErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    public void beforeEach() {
        lottoResult = new LottoResult();
    }

    @Test
    @DisplayName("당첨로또 WinningLottoTicket 이 null인 경우 에러발생")
    public void countLottoRank_winningLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = null;
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> {
            lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    @DisplayName("구매한 로또 LottoTicket 이 null인 경우 에러발생")
    public void countLottoRank_purchasedLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = null;

        assertThatThrownBy(() -> {
            lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    @DisplayName("당첨로또와 구매한 로또를 비교하여 해당 LottoRank를 count한다.")
    public void countLottoRank() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 12, 13, 14, 15, 16));

        lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        Map<LottoRank, Integer> countByRank = lottoResult.getRankCounter();

        countByRank.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e -> assertThat(e.getValue()).isEqualTo(e.getKey().getCountOfMatch()));
    }

    @Test
    @DisplayName("당첨로또와 구매한 로또를 비교한 결과를 및 구매한 로또수를 이용하여 수익률을 계산한다.")
    public void calculateYield() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16));

        lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);

        assertThat(lottoResult.calculateYield(new LottoCount(14))).isEqualTo(0.35);
    }

    @Test
    @DisplayName("구매한 로또수 0이면 수익률 계산 시 에러발생")
    public void calculateYield_lotto_count_0() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16));

        lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);

        assertThatThrownBy(() -> {
            lottoResult.calculateYield(new LottoCount(0));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoCountErrorCode.NOT_ALLOW_SMALLER_THAN_ONE.getMessage());
    }
}