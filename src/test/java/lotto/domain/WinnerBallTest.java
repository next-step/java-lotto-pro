package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoException;

public class WinnerBallTest {
    @DisplayName("당첨 티켓 생성")
    @Test
    void constructWinnerTicket() {
        WinnerBall winnerBall = new WinnerBall(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Ball.of(7));

        assertThat(winnerBall).isEqualTo(
            new WinnerBall(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), Ball.of(7)));
    }

    @DisplayName("당첨 티켓 중복 에러")
    @Test
    void throwsError_whenInvalidBonusBall() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> {
                new WinnerBall(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)), Ball.of(6));
            }).withMessage("지난 주 당첨 번호와 중복되지 않은 숫자를 입력해주세요.");
    }

    @DisplayName("당첨 결과 계산")
    @Test
    void calculateRank() {
        Tickets tickets = new Tickets(Arrays.asList(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Ticket(Arrays.asList(7, 8, 9, 10, 5, 6))));
        WinnerBall winnerBall = new WinnerBall(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Ball.of(7));

        assertThat(winnerBall.calculateRank(tickets)).isEqualTo(
            new Ranks(Arrays.asList(Rank.FIRST, Rank.MISS)));
    }
}
