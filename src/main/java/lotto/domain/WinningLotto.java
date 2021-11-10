package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.existLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }

    public Rank createWinningRank(Lotto userLotto) {
        int countOfMatch = lotto.match(userLotto);
        boolean matchBonus = userLotto.existLottoNumber(bonusNumber);
        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
