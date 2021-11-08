package step3.domain;

public class WinningLotto {
    private final LottoNumbers winningLottoNumbers;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(LottoNumbers winningLottoNumbers, LottoNumber bonusLottoNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public int containCount(LottoNumbers lottoNumbers) {
        return winningLottoNumbers.containCount(lottoNumbers);
    }

    public boolean bonusMatch(LottoNumbers lottoNumbers) {
        return lottoNumbers.isBonusContain(bonusLottoNumber);
    }

    public Object match(LottoNumbers lottoNumber) {
        return null;
    }
}
