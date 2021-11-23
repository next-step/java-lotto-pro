package lotto.domain;

import lotto.consts.WinningEnum;

import java.util.List;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    public WinningEnum getWinningResult(Lotto lotto, BonusNumber bonusNumber) {
        int matched = getMatched(lotto.getLottoNumbers());
        boolean bonusNumberMatched = false;
        if (matched == WinningEnum.SECOND.getMatched()) {
            bonusNumberMatched = isContain(lotto.getLottoNumbers(), bonusNumber.getNumber());
        }
        return WinningEnum.findByMatched(matched, bonusNumberMatched);
    }

    private int getMatched(List<LottoNumber> lottoNumbers) {
        return Long.valueOf(super.getLottoNumbers().stream().map(LottoNumber::getNumber)
                .filter(winningNumber -> isContain(lottoNumbers, winningNumber)).count()).intValue();
    }

    private boolean isContain(List<LottoNumber> lottoNumbers, Integer number) {
        return lottoNumbers.stream().map(LottoNumber::getNumber)
                .anyMatch(lottoNumber -> lottoNumber.equals(number));
    }
}
