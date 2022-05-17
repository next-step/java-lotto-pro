package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    LottoTickets lottoTickets;
    LottoNumbers winningNumbers;

    @BeforeEach
    void init() {
        winningNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)).getLottoNumbers();

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    @Test
    @DisplayName("로또 번호 매칭 결과 당첨 개수 확인")
    void match() {
        WinningResult winningResult = lottoTickets.match(winningNumbers);
        assertThat(winningResult.size()).isEqualTo(1);
    }
}
