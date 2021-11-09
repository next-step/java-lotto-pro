package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @DisplayName("일치하는 번호가 6개이면 1등")
    @Test
    void rankFirst() {
        Rank rank = Rank.rank(6);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @DisplayName("일치하는 번호가 5개이면 2등")
    @Test
    void rankSecond() {
        Rank rank = Rank.rank(5);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @DisplayName("일치하는 번호가 4개이면 3등")
    @Test
    void rankThird() {
        Rank rank = Rank.rank(4);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @DisplayName("일치하는 번호가 3개이면 4등")
    @Test
    void rankFourth() {
        Rank rank = Rank.rank(3);
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @DisplayName("일치하는 번호가 3개 미만이면 상금 없음")
    @Test
    void rankNoMatch() {
        Rank rank = Rank.rank(2);
        assertThat(rank).isEqualTo(Rank.NO_MATCH);
    }

    @DisplayName("1등 1개, 2등 1개, 4등 1개일 때 상금 구하기")
    @Test
    void getTotalWinningMoney() {
        WinningNumber winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "));
        PurchaseLotteryTicket purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(21, 2, 3, 4, 5, 6)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(Rank.getTotalWinningMoney(purchaseLotteryTicket, winningNumber)).isEqualTo(2000000000+1500000+5000);
    }
}
