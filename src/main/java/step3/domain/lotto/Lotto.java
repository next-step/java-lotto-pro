package step3.domain.lotto;

import step3.domain.factory.LottoFactory;
import step3.domain.statistics.Rank;

import java.util.Objects;

public class Lotto {

    public static final int DEFAULT_LOTTO_PRICE = 1000;

    private final int price;
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoFactory lottoFactory) {
        this.price = DEFAULT_LOTTO_PRICE;
        this.lottoNumbers = lottoFactory.create();
    }

    public Rank getRank(WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber) {
        return this.lottoNumbers.getRank(winningLottoNumbers, bonusLottoNumber);
    }

    public boolean isMatchBonus(BonusLottoNumber bonusLottoNumber) {
        return this.lottoNumbers.isContains(bonusLottoNumber);
    }

    public int getPrice() {
        return price;
    }

    public LottoNumbers value() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return price == lotto.price && Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price +
                ", lottoNumbers=" + lottoNumbers +
                '}';
    }
}
