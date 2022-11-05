package lotto.domain;

import lotto.util.Common;

public class LottoNumber implements Comparable<LottoNumber>{

    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final String INVALID_NUMBER_MESSAGE = "로또 번호는 1 이상 45 이하의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스 볼은 당첨 번호와 다른 값이어야 합니다.";
    private int lottoNumber;

    public LottoNumber(int number) {
        validateLottoNumber(number);
        this.lottoNumber = number;
    }

    public LottoNumber(String number) {
        int tempLottoNumber = Common.validateNumberType(number);
        validateLottoNumber(tempLottoNumber);
        this.lottoNumber = tempLottoNumber;
    }

    public LottoNumber(Lotto winLotto, String number) {
        int tempLottoNumber = Common.validateNumberType(number);
        validateLottoNumber(tempLottoNumber);
        validateBonusNumber(winLotto, tempLottoNumber);
        this.lottoNumber = tempLottoNumber;
    }

    private void validateBonusNumber(Lotto winLotto, int tempLottoNumber) {
        if (winLotto.isContained(new LottoNumber(tempLottoNumber))) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }

    private void validateLottoNumber(int number) {
        if (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LottoNumber compareNumber =  (LottoNumber) obj;
        return this.lottoNumber == compareNumber.lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber compareNumber) {
        return Integer.compare(this.lottoNumber, compareNumber.lottoNumber);
    }
}
