package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.exception.LottoException;

public class WinnerTicketTest {
    @DisplayName("당첨 티켓 생성")
    @Test
    void constructWinnerTicket() {
        WinnerTicket winnerTicket = new WinnerTicket(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new BonusNumber(new LottoNumber(7)));
        assertThat(winnerTicket).isEqualTo(
            new WinnerTicket(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), new BonusNumber(new LottoNumber(7))));
    }

    @DisplayName("당첨 티켓 중복 에러")
    @Test
    void throwsError_whenInvalidBonusNumber() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> {
                new WinnerTicket(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                    new BonusNumber(new LottoNumber(6)));
            }).withMessage("지난 주 당첨 번호와 중복되지 않은 숫자를 입력해주세요.");
    }

    @DisplayName("당첨 결과 계산")
    @Test
    void calculateResult() {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LottoTicket(Arrays.asList(7, 8, 9, 10, 5, 6))));
        WinnerTicket winnerTicket = new WinnerTicket(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new BonusNumber(new LottoNumber(7)));
        assertThat(winnerTicket.calculateResult(lottoTickets)).isEqualTo(
            new LottoResults(Arrays.asList(LottoResult.FIRST, LottoResult.MISS)));
    }
}
