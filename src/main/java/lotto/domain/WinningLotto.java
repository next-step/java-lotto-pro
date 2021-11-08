package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateDuplicateBonusNumber();
    }

    private void validateDuplicateBonusNumber() {
        if (this.lotto.existLottoNumber(this.bonusNumber)) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    public Rank createWinningRank(Lotto userLotto) {
        int countOfMatch = lotto.match(userLotto);
        boolean matchBonus = userLotto.existLottoNumber(bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
