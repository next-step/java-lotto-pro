package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;
import lotto.infrastructure.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;

    public WinningLottoTicket(final List<String> inputWinningLottoNumbers) {
        validateNullOrEmpty(inputWinningLottoNumbers);
        List<Integer> winningLottoNumbers = StringUtils.convertIntegers(inputWinningLottoNumbers);

        this.winningLottoTicket = new LottoTicket(winningLottoNumbers);
    }

    public int countMatchNumber(final LottoTicket lottoTicket) {
        List<Integer> winningLottoNumbers = winningLottoTicket.getReadOnlyLottoNumbers();

        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    private void validateNullOrEmpty(final List<String> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }
}
