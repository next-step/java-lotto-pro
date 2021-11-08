package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseLotteryTicketTest {

    private WinningNumber winningNumber;
    private PurchaseLotteryTicket purchaseLotteryTicket;

    @BeforeEach
    void setUp() {
        winningNumber = WinningNumber.createWinningNumber("1, 2, 3, 4, 5, 6".split(", "));
        purchaseLotteryTicket = new PurchaseLotteryTicket();
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 10, 11, 12)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(21, 2, 3, 4, 5, 6)));
        purchaseLotteryTicket.add(new LotteryTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("구매한 전체 로또 티켓에서 당첨번호 등수별 티켓 수 확인")
    @Test
    void countMatchInAllTicket() {
        Map<Rank, Integer> rankIntegerMap = purchaseLotteryTicket.countMatchInAllTicket(winningNumber);
        assertThat(rankIntegerMap.getOrDefault(Rank.FIRST, 0)).isEqualTo(1);
        assertThat(rankIntegerMap.getOrDefault(Rank.SECOND, 0)).isEqualTo(1);
        assertThat(rankIntegerMap.getOrDefault(Rank.THIRD, 0)).isEqualTo(0);
        assertThat(rankIntegerMap.getOrDefault(Rank.FOURTH, 0)).isEqualTo(3);
    }
}
