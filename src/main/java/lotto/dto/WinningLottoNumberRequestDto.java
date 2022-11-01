package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.WinningLottoNumbers;

public class WinningLottoNumberRequestDto {

    private WinningLottoNumbers winningLottoNumbers;

    public WinningLottoNumberRequestDto(String winningNumber, int bonusNumber) {
        LottoNumber lottoNumber = new LottoNumber(bonusNumber);
        this.winningLottoNumbers = new WinningLottoNumbers(winningNumber, lottoNumber);
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

}
