package lotto.auto;

public class Lotto {
    private Money price;
    private LottoNumbers lottoNumbers;

    public Lotto(String price) {
        this.price = new Money(price);
        lottoNumbers = new LottoNumbers();
    }

    public int getPrice() {
        return price.getMoney();
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
