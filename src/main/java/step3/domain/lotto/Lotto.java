package step3.domain.lotto;

public class Lotto {

    private static final int DEFAULT_LOTTO_PRICE = 1000;

    private final int price;
    private final LottoNumbers lottoNumbers;

    public Lotto(final LottoNumbers lottoNumbers) {
        this.price = DEFAULT_LOTTO_PRICE;
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(final int price, final LottoNumbers lottoNumbers) {
        this.price = price;
        this.lottoNumbers = lottoNumbers;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "price=" + price +
                ", lottoNumbers=" + lottoNumbers +
                '}';
    }
}
