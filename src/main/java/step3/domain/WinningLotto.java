package step3.domain;

import static step3.domain.WinningLottoRank.MATCH_COUNT_FOR_SECOND_OR_THIRD;

public class WinningLotto {

    private static final String EXCEPTION_MESSAGE_FOR_BONUS_NUMBER_DUPLICATION = "보너스 번호는 로또번호와 중복일 수 없습니다.";
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateWinningLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.lottoNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_FOR_BONUS_NUMBER_DUPLICATION);
        }
    }

    public WinningLottoRank rank(Lotto lotto) {
        int matchCount = 0;
        boolean matchBonus = false;
        for (LottoNumber lottoNumber : this.lotto.lottoNumbers()) {
            matchCount += lotto.getMatchPoint(lottoNumber);
        }
        if (matchCount == MATCH_COUNT_FOR_SECOND_OR_THIRD) {
            matchBonus = lotto.getMatchBonus(bonusNumber);
        }
        return WinningLottoRank.getRank(matchCount, matchBonus);
    }
}
