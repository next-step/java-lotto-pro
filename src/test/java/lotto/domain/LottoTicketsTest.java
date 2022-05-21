package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketsTest {
    LottoTickets lottoTickets;
    LottoTicket winningNumbers;
    LottoNumber bonusNumber;
    List<LottoTicket> lottoTicketList;

    @BeforeEach
    void init() {
        winningNumbers = new LottoTicket("1, 2, 3, 4, 5, 6");
        bonusNumber = new LottoNumber(7);

        lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket("1, 2, 3, 4, 5, 6"));
        lottoTickets = new LottoTickets(lottoTicketList);
    }

    @Test
    @DisplayName("로또 번호 매칭 결과 당첨 개수 확인")
    void match() {
        WinningResult winningResult = lottoTickets.match(winningNumbers, bonusNumber);
        assertThat(winningResult.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 수량과 로또 번호의 수가 일치하지 않을 경우 Exception 발생 확인")
    void notMachedQuantity() {
        assertThatThrownBy(() -> {
            new LottoTickets(lottoTicketList, 4);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
