package lotto.domain;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    WinningResult winningResult;
    LottoNumbers winningNumbers;

    @BeforeEach
    void init() {
        winningResult = new WinningResult();
        winningNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)).getLottoNumbers();

    }

    @Test
    @DisplayName("1등 당첨 로또 순위 개수 확인")
    void countRankFirst() {
        LottoNumbers firstLottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)).getLottoNumbers();
        winningResult.addWinningRank(firstLottoNumbers.rank(winningNumbers));
        assertThat(winningResult.countRank(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 로또 순위 개수 확인")
    void countRankSecond() {
        LottoNumbers secondLottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 9)).getLottoNumbers();
        winningResult.addWinningRank(secondLottoNumbers.rank(winningNumbers));
        assertThat(winningResult.countRank(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 로또 순위 개수 확인")
    void countRankThird() {
        LottoNumbers thirdLottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 8, 9)).getLottoNumbers();
        winningResult.addWinningRank(thirdLottoNumbers.rank(winningNumbers));
        assertThat(winningResult.countRank(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 로또 순위 개수 확인")
    void countRankFourth() {
        LottoNumbers fourthLottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 7, 8, 9)).getLottoNumbers();
        winningResult.addWinningRank(fourthLottoNumbers.rank(winningNumbers));
        assertThat(winningResult.countRank(LottoRank.FOURTH)).isEqualTo(1);
    }

}
