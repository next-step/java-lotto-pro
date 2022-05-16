package lotto.domain;

import lotto.infrastructure.error.LottoWinningResultErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWinningResultTest {

    private LottoWinningResult lottoWinningResult;

    @BeforeEach
    public void beforeEach() {
        lottoWinningResult = new LottoWinningResult();
    }

    @Test
    public void countRank_winningLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = null;
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> {
            lottoWinningResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    public void countRank_purchasedLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = null;

        assertThatThrownBy(() -> {
            lottoWinningResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    public void countRank() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 12, 13, 14, 15, 16));

        lottoWinningResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        Map<LottoRank, Integer> countByRank = lottoWinningResult.getRankCounter();

        countByRank.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e -> assertThat(e.getValue()).isEqualTo(e.getKey().getCountOfMatch()));
    }

    @Test
    public void calculateYield() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16));

        lottoWinningResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);

        assertThat(lottoWinningResult.calculateYield(14)).isEqualTo(0.35);
    }

    @Test
    public void calculateYield_lotto_count_0() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16));

        lottoWinningResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);

        assertThatThrownBy(() -> {
            lottoWinningResult.calculateYield(0);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.LOTTO_COUNT_ALLOW_BIGGER_THAN_ZERO.getMessage());
    }
}