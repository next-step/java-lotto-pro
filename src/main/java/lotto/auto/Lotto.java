package lotto.auto;

import java.util.List;

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

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    @Override
    public String toString() {
        return lottoNumbers.getLottoNumbers().toString();
    }
}
