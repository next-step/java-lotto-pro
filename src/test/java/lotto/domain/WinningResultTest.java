package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {
    WinningResult winningResult;
    LottoTicket winningNumbers;
    LottoNumber bonusNumber;

    @BeforeEach
    void init() {
        winningResult = new WinningResult();
        winningNumbers = new LottoTicket("1, 2, 3, 4, 5, 6");
        bonusNumber = new LottoNumber(7);

        LottoTicket firstLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        winningResult.addWinningRank(firstLottoTicket.rank(winningNumbers, bonusNumber));

        LottoTicket secondLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 7");
        winningResult.addWinningRank(secondLottoTicket.rank(winningNumbers, bonusNumber));

        LottoTicket thirdLottoTicket = new LottoTicket("1, 2, 3, 4, 5, 9");
        winningResult.addWinningRank(thirdLottoTicket.rank(winningNumbers, bonusNumber));

        LottoTicket fourthLottoTicket = new LottoTicket("1, 2, 3, 4, 8, 9");
        winningResult.addWinningRank(fourthLottoTicket.rank(winningNumbers, bonusNumber));

        LottoTicket fifthLottoTicket = new LottoTicket("1, 2, 3, 7, 8, 9");
        winningResult.addWinningRank(fifthLottoTicket.rank(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("1등 당첨 로또 순위 개수 확인")
    void countRankFirst() {
        assertThat(winningResult.countRank(LottoRank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("2등 당첨 로또 순위 개수 확인")
    void countRankSecond() {
        assertThat(winningResult.countRank(LottoRank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("3등 당첨 로또 순위 개수 확인")
    void countRankThird() {
        assertThat(winningResult.countRank(LottoRank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("4등 당첨 로또 순위 개수 확인")
    void countRankFourth() {
        assertThat(winningResult.countRank(LottoRank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("5등 당첨 로또 순위 개수 확인")
    void countRankFifth() {
        assertThat(winningResult.countRank(LottoRank.FIFTH)).isEqualTo(1);
    }


    @Test
    @DisplayName("로또 수익률 확인")
    void profitRate() {
        Money money = new Money(10000);
        assertThat(winningResult.profitRate(money)).isEqualTo(203155.5d);
    }

    @Test
    @DisplayName("로또 총 당첨 금액 확인")
    void totalPrizeMoney() {
        assertThat(winningResult.totalPrizeMoney()).isEqualTo(2031555000);
    }

    @DisplayName("수익률 손해")
    @Test
    void loss() {
        Money money = new Money("2031556000");
        assertThat(winningResult.profitResultDescription(money)).contains("손해");
    }

    @DisplayName("수익률 본전")
    @Test
    void principal() {
        Money money = new Money("2031555000");
        assertThat(winningResult.profitResultDescription(money)).contains("본전이");
    }

    @DisplayName("수익률 이득")
    @Test
    void profit() {
        Money money = new Money("10000");
        assertThat(winningResult.profitResultDescription(money)).contains("이득이");
    }
}
