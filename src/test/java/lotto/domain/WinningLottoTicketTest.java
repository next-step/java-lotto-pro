package lotto.domain;

import lotto.domain.error.LottoNumberErrorCode;
import lotto.domain.error.LottoTicketErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {

    private final String bonusBall = "45";

    @ParameterizedTest(name = "inputWinningLottoNumbers가 null 또는 empty 인 경우 에러발생")
    @NullAndEmptySource
    public void inputWinningLottoNumbers_null_or_empty(List<String> inputWinningLottoNumbers) {
        assertThatThrownBy(() -> new WinningLottoTicket(inputWinningLottoNumbers, "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("중복된 로또번호가 있을 시 에러발생")
    public void inputWinningLottoNumbers_duplicate_number() {
        assertThatThrownBy(() -> new WinningLottoTicket(Arrays.asList("1", "1", "1", "1", "1", "1"), bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("로또번호가 6개를 초과한 경우 에러발생")
    public void inputWinningLottoNumbers_size_bigger() {
        assertThatThrownBy(() -> new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", "6", "7"), bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    @DisplayName("로또번호가 6개보다 작은 경우 에러발생")
    public void inputWinningLottoNumbers_size_smaller() {
        assertThatThrownBy(() -> new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5"), bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(LottoTicketErrorCode.INVALID_LOTTO_NUMBER_SIZE.getMessage(),
                        LottoTicket.LOTTO_SIZE));
    }

    @Test
    @DisplayName("로또번호가 아닌 숫자가 존재하면 에러발생")
    public void inputWinningLottoNumbers_로또번호가_아닌_숫자() {
        assertThatThrownBy(() -> new WinningLottoTicket(Arrays.asList("100", "200", "300", "400", "500", "600"), bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(
                                LottoNumberErrorCode.INVALID_LOTTO_NUMBER.getMessage(),
                                LottoNumber.MIN,
                                LottoNumber.MAX)
                );
    }

    @Test
    @DisplayName("보너스볼이 로또번호와 중복될 경우 에러발생")
    public void bonusBall_duplicate_lotto_numbers() {
        assertThatThrownBy(() -> new WinningLottoTicket(Arrays.asList("1", "2", "3", "4", "5", bonusBall), bonusBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
    }

    @ParameterizedTest(name = "당첨번호와 구매한 로또번호를 비교하여 일치하는 번호 갯수를 반환한다.")
    @MethodSource("provideLottoTicketForMatchCount")
    public void countMatchNumber(LottoTicket lottoTicket, int countOfMatch) {
        List<String> lottoNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(lottoNumbers, bonusBall);

        assertThat(winningLottoTicket.countMatchNumber(lottoTicket)).isEqualTo(countOfMatch);
    }

    private static Stream<Arguments> provideLottoTicketForMatchCount() {
        return Stream.of(
                Arguments.of(new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16)), 0),
                Arguments.of(new LottoTicket(Arrays.asList(1, 12, 13, 14, 15, 16)), 1),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 13, 14, 15, 16)), 2),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 14, 15, 16)), 3),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 15, 16)), 4),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 16)), 5),
                Arguments.of(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)), 6)
        );
    }
}