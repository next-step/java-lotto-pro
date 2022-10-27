package step3.model;

import static step3.constant.ErrorMessage.ONLY_NUMBER_PURCHASE_PRICE_INPUT;

public class LottoGenerator {

    private int purchasePrice;

    public void initPurchasePrice(String purchasePrice) {
        try {
            this.purchasePrice = Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_PURCHASE_PRICE_INPUT);
        }
    }

    public Lottos generateLottos() {
        Lottos lottos = new Lottos();
        lottos.generate(getGeneratorCount());
        return lottos;
    }

    public int getGeneratorCount() {
        return purchasePrice / 1000;
    }

}
