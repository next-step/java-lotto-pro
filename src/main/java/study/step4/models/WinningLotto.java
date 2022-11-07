package study.step4.models;

import study.step4.helper.LottoStringParser;

import java.util.List;

public class WinningLotto {
    private List<LottoNumber> winningLottoNumbers;

    public WinningLotto(String winningLottoNumbers) {
        this.winningLottoNumbers = LottoStringParser.stringToLottoNumbers(winningLottoNumbers);
    }

    public boolean contains(LottoNumber bonusBallNumber) {
        return winningLottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.compare(bonusBallNumber) == 0);
    }
}
