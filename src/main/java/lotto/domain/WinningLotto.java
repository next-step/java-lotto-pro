package lotto.domain;

public class WinningLotto {

    private final Lotto winNumber;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winNumber, LottoNumber bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult getWinningResult(Lotto lotto) {
        int matchedCount = lotto.getMatchedCount(winNumber);
        boolean bonusNumberMatched = lotto.isContained(bonusNumber);
        return WinningResult.of(matchedCount, bonusNumberMatched);
    }
}
