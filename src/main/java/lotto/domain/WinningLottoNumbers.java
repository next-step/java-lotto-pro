package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public WinningLottoNumbers(String lottoNumbers, LottoNumber bonusNumber) {
        LottoNumbers winningLottoNumbers = new ManualLottoGenerator(lottoNumbers).generateLottoNumber();
        checkDuplicatedBonusNumber(winningLottoNumbers.numbers(), bonusNumber.getNumber());
        this.lottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkDuplicatedBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨된 로또 번호와 보너스 번호는 일치할 수 없습니다.");
        }
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
