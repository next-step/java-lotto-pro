package step3.model;

import static step3.constant.ErrorMessage.ONLY_NUMBER_PURCHASE_PRICE_INPUT;

public class LottoGenerator {

    public Lottos generateLottos(String price) {
        Lottos lottos = new Lottos();
        lottos.generate(getGeneratorCount(price));
        return lottos;
    }

    public Lotto generateLotto(String numbers) {
        return new Lotto(numbers);
    }

    public LottoNumber generateLottoNumber(String number) {
        return new LottoNumber(number);
    }

    public int getGeneratorCount(String price) {
        try {
            int purchasePrice = Integer.parseInt(price);
            return purchasePrice / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_PURCHASE_PRICE_INPUT);
        }
    }

}
