package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTicketTest {

    @DisplayName("로또티켓 생성 테스트")
    @Test
    void constructLottoTicket_success() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("입력받은 로또티켓 생성 테스트")
    @Test
    void constructLottoTicketFromText_success() {
        LottoTicket lottoTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또티켓 메시지 생성 테스트")
    @Test
    void makeMessage_success() {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoTicket.makePrintableMessage()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("로또티켓 결과 계산")
    @ParameterizedTest
    @CsvSource(value = {"4, 5, 6, 7, 8, 9;THREE", "4, 5, 6, 1, 8, 9;FOUR", "4, 5, 6, 1, 2, 9;FIVE",
        "4, 5, 6, 1, 2, 3;SIX", "7, 8, 9, 10, 11, 12;NONE"}, delimiter = ';')
    public void calculateResult(String text, String resultName) {
        LottoTicket lottoTicket = new LottoTicket(text);
        assertThat(lottoTicket.calculateResult(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))))
            .isEqualTo(LottoResult.valueOf(resultName));
    }
}