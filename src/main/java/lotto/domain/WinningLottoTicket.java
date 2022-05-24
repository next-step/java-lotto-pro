package lotto.domain;

import lotto.domain.error.LottoTicketErrorCode;

import java.util.List;
import java.util.Objects;

public class WinningLottoTicket {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusBall;

    public WinningLottoTicket(final List<Integer> winningLottoNumbers, final Integer bonusBall) {
        validateNullOrEmpty(winningLottoNumbers, bonusBall);
        validateDuplicate(winningLottoNumbers, bonusBall);

        this.winningLottoTicket = new LottoTicket(winningLottoNumbers);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    private void validateNullOrEmpty(final List<Integer> lottoNumbers, Integer bonusBall) {
        if (Objects.isNull(bonusBall)) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_BONUS_BALL_NULL.getMessage());
        }

        if (Objects.isNull(lottoNumbers) || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
        }

    }

    private void validateDuplicate(List<Integer> winningLottoNumbers, final Integer bonusBall) {
        if (winningLottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(LottoTicketErrorCode.NOT_ALLOW_DUPLICATE.getMessage());
        }
    }

    public LottoRank match(final LottoTicket purchasedLottoTicket) {
        int countMatchNumber = countMatchNumber(purchasedLottoTicket);
        boolean matchBonus = matchBonus(purchasedLottoTicket);

        return LottoRank.valueOf(countMatchNumber, matchBonus);
    }

    private int countMatchNumber(final LottoTicket lottoTicket) {
        List<LottoNumber> winningLottoNumbers = winningLottoTicket.getLottoNumbers();

        return (int) winningLottoNumbers.stream()
                .filter(lottoTicket::contains)
                .count();
    }

    private boolean matchBonus(final LottoTicket purchasedLottoTicket) {
        return purchasedLottoTicket.contains(bonusBall);
    }
}
