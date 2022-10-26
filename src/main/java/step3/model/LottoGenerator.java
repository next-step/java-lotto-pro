package step3.model;

import static step3.constant.ErrorMessage.ONLY_NUMBER_PURCHASE_PRICE_INPUT;

public class LottoGenerator {

    private Lottos lottos;

    private int purchasePrice;
    private int generatorCount;

    public void initPurchasePrice(String purchasePrice) {
        try {
            this.purchasePrice = Integer.parseInt(purchasePrice);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_PURCHASE_PRICE_INPUT);
        }
    }

    public int calculatorPurchaseCount() {
        this.generatorCount = this.purchasePrice / 1000;
        return this.generatorCount;
    }

    public Lottos generateLottos() {
        this.lottos = new Lottos();
        for (int i = 0; i < generatorCount; i++) {
            lottos.addLotto(generateLotto());
        }
        return this.lottos;
    }

    public Lotto generateLotto() {
        Lotto lotto = new Lotto();
        return lotto.createLotto();
    }

    public int totalPurchasePrice() {
        return this.purchasePrice;
    }
}
