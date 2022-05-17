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

    @DisplayName("여러 장의 로또 생성 후 로또 티켓 1장 추가")
    @Test
    void test_여러장의_로또_생성후_1장_추가() {
        //when
        lottoTickets.addTicket(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //then
        assertThat(lottoTickets.size()).isEqualTo(4);
    }

    @DisplayName("여러 장의 로또 생성 후 로또 티켓s 추가")
    @Test
    void test_여러장의_로또_생성후_추가() {
        //when
        lottoTickets.addAll(lottoTickets);
        //then
        assertThat(lottoTickets.size()).isEqualTo(6);
    }

    @DisplayName("로또 티켓이 포함되어 있는지 확인")
    @Test
    void test_로또_티켓_포함되어_있는지() {
        //when & then
        assertThat(lottoTickets.contains(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @DisplayName("로또 티켓이 포함되지 않은 경우 확인")
    @Test
    void test_로또_티켓_포함되지_않은_경우() {
        //when & then
        assertThat(lottoTickets.contains(LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 7)))).isFalse();
    }
}