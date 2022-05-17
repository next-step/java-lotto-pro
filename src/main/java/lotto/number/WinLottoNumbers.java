package lotto.number;

import lotto.rank.LottoRank;

public class WinLottoNumbers {
    private LottoNumbers winlottoMainNumbers;
    private LottoNumber bonusNumber;

    private WinLottoNumbers(LottoNumbers winlottoMainNumbers, LottoNumber bonusNumber) {
        if(winlottoMainNumbers == null || bonusNumber == null){
            throw new IllegalArgumentException("보너스번호 혹은 당첨번호가 없어서 생성할 수 없습니다.");
        }
        this.winlottoMainNumbers = winlottoMainNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(LottoNumbers lottoNumbers) {
        int matchCount = matchMainNumber(lottoNumbers);
        boolean containsBonusNumber = lottoNumbers.contains(bonusNumber);
        return LottoRank.getRank(matchCount,containsBonusNumber);
    }

    private int matchMainNumber(LottoNumbers lottoNumbers){
        return (int) lottoNumbers
                .getLottoNumberList()
                .stream()
                .filter(this::hasNumber)
                .count();
    }

    private boolean hasNumber(LottoNumber number) {
        return winlottoMainNumbers.contains(number);
    }

    public static class Builder{
        private LottoNumbers lottoNumbers;
        private LottoNumber bonusNumber;

        public static class RequiredLottoNumbersBuilder{
            public Builder lottoNumbers(LottoNumbers lottoNumbers){
                Builder builder = new Builder();
                builder.lottoNumbers = lottoNumbers;
                return builder;
            }
        }

        public static RequiredLottoNumbersBuilder getInstance(){
            return new RequiredLottoNumbersBuilder();
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
