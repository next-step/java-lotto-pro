package step3.domain.lotto;

import step3.domain.factory.LottoFactory;
import step3.domain.statistics.Rank;

public class Lotto {

    public static final int DEFAULT_LOTTO_PRICE = 1000;

    private final int price;
    private final LottoNumbers lottoNumbers;
    private final LottoType lottoType;

    public Lotto(LottoFactory lottoFactory) {
        this.price = DEFAULT_LOTTO_PRICE;
        this.lottoNumbers = lottoFactory.create();
        this.lottoType = lottoFactory.getLottoType();
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

    public LottoType getLottoType() {
        return lottoType;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price +
                ", lottoNumbers=" + lottoNumbers +
                '}';
    }
}
