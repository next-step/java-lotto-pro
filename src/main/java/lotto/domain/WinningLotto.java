package lotto.domain;

import static lotto.domain.LottoWinningRank.findRankByContainCountAndBonusContain;

public class WinningLotto {

    private Lotto basicLotto;
    private LottoNumber bonusNumber;
    public static final int FIVE = 5;
    private WinningLotto() {}

    public static WinningLotto create(Lotto basicLotto, LottoNumber bonusNumber){
        WinningLotto winningLotto = new WinningLotto();

        winningLotto.basicLotto = basicLotto;
        validateDuplicateBonusNumber(basicLotto, bonusNumber);
        winningLotto.bonusNumber = bonusNumber;

        return winningLotto;
    }

    private static void validateDuplicateBonusNumber(Lotto basicLotto, LottoNumber bonusNumber) {
        if(basicLotto.isContain(bonusNumber)){
            throw new IllegalArgumentException("보너스 볼 번호가 기존 당첨번호에 중복되어 있습니다.");
        }
    }

    private int getMatchCountByBasic(Lotto lotto) {
        return lotto.getContainNumberCount(this.basicLotto);
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain(this.bonusNumber);
    }

    public LottoWinningRank getLottoRank(Lotto lotto) {
        int matchCountByBasic = getMatchCountByBasic(lotto);
        boolean isBonusContain = false;
        if(matchCountByBasic == FIVE){
            isBonusContain = isContainBonusNumber(lotto);
        }

        return findRankByContainCountAndBonusContain(matchCountByBasic, isBonusContain);
    }
}
