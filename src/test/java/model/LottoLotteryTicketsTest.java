package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoLotteryTicketsTest {

    @BeforeEach
    void setUp() {}

    @Test
    @DisplayName("로또 금액에 맞는 티켓 정상적으로 생성하는 테스트")
    void lotto_generator_generate_test() {
        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(10, new LottoNumberGenerator());

        assertThat(lottoLotteryTickets.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("로도 수동 포함 자동 생성 테스트")
    void create_lotto_lottery_tickets_generate_test() {
        LottoLotteryTickets lottoLotteryTickets = new LottoLotteryTickets(3, new LottoNumberGenerator());

        assertThat(LottoLotteryTickets.createLottoLotteryTickets(lottoLotteryTickets, 6).size()).isEqualTo(9);
    }
}