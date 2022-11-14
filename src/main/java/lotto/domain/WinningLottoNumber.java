package lotto.domain;

import lotto.common.ErrorMessage;

public class WinningLottoNumber {
    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    public WinningLottoNumber(String winningLottoTicket, int bonusNumber) {
        this.winningLottoTicket = new LottoTicket(winningLottoTicket);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
        validateDuplication();
    }

    private void validateDuplication() {
        if (this.winningLottoTicket.includedBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_LOTTO_BONUS_NUMBER_DUPLICATION);
        }
    }

    public Rank check(LottoTicket purchasedTicket) {
        return Rank.valueOf(purchasedTicket.compareTicket(this.winningLottoTicket), purchasedTicket.includedBonusNumber(this.bonusNumber));
    }
}
