package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketsTest {
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        //given
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketList.add(LottoTicket.from(Arrays.asList(1, 2, 3, 7, 5, 6)));
        lottoTicketList.add(LottoTicket.from(Arrays.asList(7, 8, 9, 10, 11, 12)));
        lottoTickets = LottoTickets.from(lottoTicketList);
    }

    @DisplayName("여러 장의 로또 생성")
    @Test
    void test_여러장의_로또_생성() {
        //when & then
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

    @DisplayName("로또 매칭 결과 당첨 개수 조회(보너스볼 포함)")
    @Test
    void test_로또_매칭_보너스볼_포함() {
        //when
        LottoWinningRanks lottoWinningRanks = lottoTickets.match(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        //then
        assertThat(lottoWinningRanks.size()).isEqualTo(2);
    }
}