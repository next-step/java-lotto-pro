package lotto.domain;

import lotto.exception.BonusNumberDuplicateException;

import java.util.List;

//로또 하나에 대한 당첨 결과를 산정하는 책임을 가진 클래스
public class WinningLotto {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;

    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        duplicateWinningNumberAndBonusNumberValid(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank rankResult(Lotto lotto) {
        int winningNumberMatch = lotto.winningNumberMatch(winningNumber);
        boolean bonusNumberMatch = lotto.contains(bonusNumber);

        return Rank.of(winningNumberMatch, bonusNumberMatch);
    }

    private void duplicateWinningNumberAndBonusNumberValid(Lotto winningNumber, LottoNumber bonusNumber) {
        List<LottoNumber> winningNumbers = winningNumber.lottoNumbers();
        if (winningNumbers.contains(bonusNumber)) {
            throw new BonusNumberDuplicateException();
        }
    }
}

