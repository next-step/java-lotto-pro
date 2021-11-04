package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningReportTest {
    LottoTicketBundle lottoTicketBundle;

    @BeforeEach
    void beforeEach() {
        lottoTicketBundle = new LottoTicketBundle();
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:0.5"}, delimiter = ':')
    @DisplayName("투자금: 10000, 수익률 0.5 테스트")
    void toString_수익률_테스트(int totalAmount, double yield) {
        // given
        lottoTicketBundle.addLottoTicket(1, 2, 3, 4, 5, 6);
        LottoTicket winningLottoTicket = new LottoTicket(new int[] {1, 2, 3, 10, 11, 12});

        // when
        LottoWinningReport lottoWinningReport = new LottoWinningReport(lottoTicketBundle, winningLottoTicket,
            totalAmount);

        // then
        assertThat(lottoWinningReport.toString().contains(String.valueOf(yield))).isTrue();
    }

}
