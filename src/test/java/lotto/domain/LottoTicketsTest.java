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
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoNumbersList.add(new LottoNumbers(Arrays.asList(7, 8, 9, 10, 11, 12)));
        lottoTickets = new LottoTickets(lottoNumbersList);
    }

    @DisplayName("여러 장의 로또 생성")
    @Test
    void test_여러장의_로또_생성() {
        //when & then
        assertThat(lottoTickets.size()).isEqualTo(2);
    }

    @DisplayName("로또 매칭 결과 당첨 개수 조회")
    @Test
    void test_로또_매칭() {
        //when
        LottoWinningRanks lottoWinningRanks = lottoTickets.match(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        //then
        assertThat(lottoWinningRanks.size()).isEqualTo(1);
    }
}