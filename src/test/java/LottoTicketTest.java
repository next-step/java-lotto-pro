import lotto.LottoNumber;
import lotto.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    void 생성() {
        LottoTicket lottoTicket = new LottoTicket(14000);
        assertThat(lottoTicket.size()).isEqualTo(14);
    }

    @Test
    void 생성_예외() {
        assertThatThrownBy(() -> {
            LottoTicket lottoTicket = new LottoTicket(900);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:3", "2:1", "3:2", "6:1"}, delimiter = ':')
    void 당첨_확인(long input, int expected) {
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(
                Arrays.asList(10, 11, 12, 13, 14, 15),
                Arrays.asList(6, 10, 11, 12, 13, 14),
                Arrays.asList(5, 10, 11, 12, 13, 14),
                Arrays.asList(4, 10, 11, 12, 13, 14),
                Arrays.asList(1, 2, 10, 11, 12, 13),
                Arrays.asList(1, 2, 3, 10, 11, 12),
                Arrays.asList(1, 2, 4, 10, 11, 12),
                Arrays.asList(1, 2, 3, 4, 5, 6)));

        Map<Long, Integer> result = lottoTicket.check(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertThat(result).containsEntry(input, expected);
    }
}
