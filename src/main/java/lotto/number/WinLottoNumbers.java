package lotto.number;

import lotto.rank.LottoRank;

public class WinLottoNumbers {
    private LottoNumbers winlottoMainNumbers;
    private LottoNumber bonusNumber;

    private WinLottoNumbers(Builder builder) {
        this(builder.lottoNumbers, builder.bonusNumber);
    }

    private WinLottoNumbers(LottoNumbers winlottoMainNumbers, LottoNumber bonusNumber) {
        if (winlottoMainNumbers == null || bonusNumber == null) {
            throw new IllegalArgumentException("보너스번호 혹은 당첨번호가 없어서 생성할 수 없습니다.");
        }
        if (winlottoMainNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호와 중복될 수 없습니다.");
        }
        this.winlottoMainNumbers = winlottoMainNumbers;
        this.bonusNumber = bonusNumber;
    }


    public LottoRank match(LottoNumbers lottoNumbers) {
        int matchCount = matchMainNumber(lottoNumbers);
        boolean containsBonusNumber = lottoNumbers.contains(bonusNumber);
        return LottoRank.getRank(matchCount, containsBonusNumber);
    }

    private int matchMainNumber(LottoNumbers lottoNumbers) {
        return (int) lottoNumbers
                .getLottoNumberList()
                .stream()
                .filter(this::hasNumber)
                .count();
    }

    private boolean hasNumber(LottoNumber number) {
        return winlottoMainNumbers.contains(number);
    }

    public static class Builder {
        private LottoNumbers lottoNumbers;
        private LottoNumber bonusNumber;

        private Builder() {

        }

        public static Builder getInstance() {
            return new Builder();
        }

        public RequiredBonusNumberBuilder lottoNumbers(LottoNumbers lottoNumbers) {
            this.lottoNumbers = lottoNumbers;
            return new RequiredBonusNumberBuilder(this);
        }

        public class RequiredBonusNumberBuilder {
            private Builder rootBuilder;

            private RequiredBonusNumberBuilder(Builder builder) {
                this.rootBuilder = builder;
            }

            public ConfiguredBuilder bonusNumber(LottoNumber bonusNumber) {
                rootBuilder.bonusNumber = bonusNumber;
                return new ConfiguredBuilder(rootBuilder);
            }
        }

        public class ConfiguredBuilder {
            private Builder rootBuilder;

            private ConfiguredBuilder(Builder builder) {
                this.rootBuilder = builder;
            }

            public WinLottoNumbers build() {
                return new WinLottoNumbers(rootBuilder);
            }

        }
    }
}
