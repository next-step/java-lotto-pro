package lotto.number;

import lotto.rank.LottoRank;

public class WinLottoNumbers {
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    private WinLottoNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if(lottoNumbers == null || bonusNumber == null){
            throw new IllegalArgumentException("보너스번호 혹은 당첨번호가 없어서 생성할 수 없습니다.");
        }
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        int matchCount = matchMainNumber(lottoNumbers);
        boolean containsBonusNumber = lottoNumbers.contains(bonusNumber);
        return LottoRank.getRank(matchCount,containsBonusNumber);
    }

    private int matchMainNumber(LottoNumbers lottoNumbers){
        int matchCount = 0;
        for (LottoNumber number : lottoNumbers.getLottoNumberList()) {
            matchCount += hasNumber(number);
        }
        return matchCount;
    }

    private int hasNumber(LottoNumber number) {
        if (lottoNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public static class Builder{
        private LottoNumbers lottoNumbers;
        private LottoNumber bonusNumber;
        public static Builder getInstance(){
            return new Builder();
        }
        public Builder lottoNumbers(LottoNumbers lottoNumbers){
            this.lottoNumbers=lottoNumbers;
            return this;
        }
        public Builder bonusNumber(LottoNumber bonusNumber){
            if(lottoNumbers.contains(bonusNumber)){
                throw new IllegalArgumentException("보너스번호는 당첨번호와 중복될 수 없습니다.");
            }
            this.bonusNumber = bonusNumber;
            return this;
        }
        public WinLottoNumbers build(){
            return new WinLottoNumbers(lottoNumbers,bonusNumber);
        }
    }
}
