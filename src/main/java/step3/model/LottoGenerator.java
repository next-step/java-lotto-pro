package step3.model;

public class LottoGenerator {
    private int purchasePrice;
    private Lottos lottos = new Lottos();

    public void setPurchasePrice(String price) {
        //todo price 1000원 단위인지 validate
        this.purchasePrice = Integer.parseInt(price);
    }

    public Lottos generateLottos() {
        // 로또 총 수량
        lottos.setPurchasedCount(purchasePrice);

        generateLotto();
        return lottos;
    }

    private void generateLotto() {

    }
}
