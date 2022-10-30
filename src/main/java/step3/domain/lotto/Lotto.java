package step3.domain.lotto;

import step3.domain.statistics.Rank;

public class Lotto {

    public static final int DEFAULT_LOTTO_PRICE = 1000;

    private final int price;
    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        this.price = DEFAULT_LOTTO_PRICE;
        this.lottoNumbers = lottoNumbers;
    }

    public Rank getRank(WinningLottoNumbers winningLottoNumbers) {
        return this.lottoNumbers.getRank(winningLottoNumbers);
    }

    public int getPrice() {
        return price;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price +
                ", lottoNumbers=" + lottoNumbers +
                '}';
    }
}
