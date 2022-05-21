package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;
import lotto.infrastructure.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusBall;

    public WinningLottoTicket(final List<String> inputWinningLottoNumbers, final String bonusBall) {
        validateNullOrEmpty(inputWinningLottoNumbers);
        List<Integer> winningLottoNumbers = StringUtils.convertIntegers(inputWinningLottoNumbers);

        this.winningLottoTicket = new LottoTicket(winningLottoNumbers);
        this.bonusBall = new LottoNumber(bonusBall);

        validateDuplicate(this.winningLottoTicket, this.bonusBall);
    }

    private void validateNullOrEmpty(final List<String> lottoNumbers) {
        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }
    }

    private void validateDuplicate(LottoTicket winningLottoTicket, LottoNumber bonusBall) {
        if (winningLottoTicket.contains(bonusBall)) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
        }
    }

    public int countMatchNumber(final LottoTicket lottoTicket) {
        List<LottoNumber> winningLottoNumbers = winningLottoTicket.getLottoNumbers();

        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    public boolean matchBonus(final LottoTicket purchasedLottoTicket) {
        return purchasedLottoTicket.contains(bonusBall);
    }
}
