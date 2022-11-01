package model;

import exception.LottoNumberDuplicationException;

public class WinningLottoNumbers {
    public static final int BONUS_BALL_ADD_DELIMETER = 1;
    private static final String LOTTO_NUMBERS_DUPLICATION_ERROR_MESSSAGE = "기존에 중복된 로또번호가 존재합니다.";
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusBall;

    public WinningLottoNumbers(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void validDuplicationLottoNumber(LottoNumber lottoNumber, LottoNumber bonusBall) {
        if (lottoNumber.equals(bonusBall)) {
            throw new LottoNumberDuplicationException(LOTTO_NUMBERS_DUPLICATION_ERROR_MESSSAGE);
        }
    }

    public LottoNumber getBonusBall() {
        return this.bonusBall;
    }

    public void addBonusBall(LottoNumber bonusBall) {
        if (lottoNumbers.containLottoNumber(bonusBall)) {
            throw new LottoNumberDuplicationException(LOTTO_NUMBERS_DUPLICATION_ERROR_MESSSAGE);
        }

        this.bonusBall = bonusBall;
    }

    public boolean equalsBonusBall(LottoNumber lottoNumber) {
        if (lottoNumber.equals(bonusBall)) {
            return true;
        }

        return false;
    }

    public int matchExceptBonusBall(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.match(lottoNumbers);
    }
}
