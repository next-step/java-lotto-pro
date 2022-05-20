package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;
import lotto.infrastructure.util.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoTicketTest {

    @ParameterizedTest(name = "inputWinningLottoNumbers가 null 또는 empty 인 경우 에러발생")
    @NullAndEmptySource
    public void inputWinningLottoNumbers_null_or_empty(List<String> inputWinningLottoNumbers) {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(inputWinningLottoNumbers);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("중복된 로또번호가 있을 시 에러발생")
    public void inputWinningLottoNumbers_duplicate_number() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "1", "1", "1", "1", "1"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("로또번호가 6개를 초과한 경우 에러발생")
    public void inputWinningLottoNumbers_size_bigger() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6", "7"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    @DisplayName("로또번호가 6개보다 작은 경우 에러발생")
    public void inputWinningLottoNumbers_size_smaller() {
        assertThatThrownBy(() -> {
            new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5"));
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    @DisplayName("로또번호가 아닌 숫자가 존재하면 에러발생")
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
    @DisplayName("당첨번호와 구매한 로또번호를 비교하여 일치하는 번호 갯수를 반환한다.")
    public void countMatchNumber() {
        List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumbers);

        assertAll(
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16)))).isZero();
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(1, 12, 13, 14, 15, 16)))).isEqualTo(1);
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(1, 2, 13, 14, 15, 16)))).isEqualTo(2);
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16)))).isEqualTo(3);
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(1, 2, 3, 4, 15, 16)))).isEqualTo(4);
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 16)))).isEqualTo(5);
                },
                () -> {
                    assertThat(winningLottoTicket.countMatchNumber(new LottoTicket(StringUtils.convertIntegers(lottoNumbers))))
                            .isEqualTo(lottoNumbers.size());
                }
        );
    }
}