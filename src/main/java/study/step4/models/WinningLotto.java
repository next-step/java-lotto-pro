package study.step4.models;

import study.step4.exception.BonusBallNumberInWinningLottoException;
import study.step4.exception.LottoInvalidSizeException;
import study.step4.helper.LottoStringParser;

import java.util.List;

public class WinningLotto {
    private final List<LottoNumber> winningLottoNumbers;

    public WinningLotto(List<LottoNumber> winningLottoNumbers) {
        validateWinningLottoSize(winningLottoNumbers);
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public WinningLotto(String winningLottoNumbers) {
        this(LottoStringParser.stringToLottoNumbers(winningLottoNumbers));
    }

    public boolean contains(LottoNumber bonusBallNumber) {
        return winningLottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.compare(bonusBallNumber) == 0);
    }

    private void validateWinningLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.LOTTO_SIZE) {
            throw new LottoInvalidSizeException(String.format("당첨번호 사이즈는 %d이어야 합니다.", Lotto.LOTTO_SIZE));
        }
    }

    public void validateNotInWinningLotto(LottoNumber bonusBall) {
        if (winningLottoNumbers.contains(bonusBall)) {
            throw new BonusBallNumberInWinningLottoException("보너스 번호는 당첨 번호와 달라야 합니다.");
        }
    }
}
