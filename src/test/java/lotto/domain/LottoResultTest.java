package lotto.domain;

import lotto.domain.error.LottoCountErrorCode;
import lotto.domain.error.LottoWinningResultErrorCode;
import org.junit.jupiter.api.BeforeEach;
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
    public void countRank_winningLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = null;
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> {
            lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    public void countRank_purchasedLottoTicket_null() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = null;

        assertThatThrownBy(() -> {
            lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoWinningResultErrorCode.NOW_ALLOW_NULL.getMessage());
    }

    @Test
    public void countRank() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 12, 13, 14, 15, 16));

        lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);
        Map<LottoRank, Integer> countByRank = lottoResult.getRankCounter();

        countByRank.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .forEach(e -> assertThat(e.getValue()).isEqualTo(e.getKey().getCountOfMatch()));
    }

    @Test
    public void calculateYield() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket purchasedLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16));

        lottoResult.countLottoRank(winningLottoTicket, purchasedLottoTicket);

        assertThat(lottoResult.calculateYield(new LottoCount(14))).isEqualTo(0.35);
    }

    @Test
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