package step3.model;

public class LottoGenerator {
    private int purchasePrice;
    private Lottos lottos = new Lottos();

    public void setPurchasePrice(String price) {
        //todo price 1000원 단위인지 validate
        this.purchasePrice = Integer.parseInt(price);
    }

    public Lottos generateLottos() {
        lottos.setPurchasedCount(purchasePrice);
        lottos.setLottos();
        return lottos;
    }
}
