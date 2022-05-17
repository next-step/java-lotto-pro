package lotto.domain;

import lotto.infrastructure.error.LottoTicketErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void inputWinningLottoNumbers_null_or_empty(List<String> inputWinningLottoNumbers) {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(inputWinningLottoNumbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    public void inputWinningLottoNumbers_duplicate_number() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "1", "1", "1", "1", "1"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    public void inputWinningLottoNumbers_size_bigger() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    public void inputWinningLottoNumbers_size_smaller() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    public void inputWinningLottoNumbers_로또번호가_아닌_숫자() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("100", "200", "300", "400", "500", "600"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(
                                LottoTicketErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoTicket.LOTTO_MIN_NUMBER,
                                LottoTicket.LOTTO_MAX_NUMBER)
                );
    }

    @Test
    public void countMatchNumber() {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6"));
        LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        
        Assertions.assertThat(winningLottoTicket.countMatchNumber(lottoTicket)).isEqualTo(6);
    }
}