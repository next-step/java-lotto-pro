package lotto;

public class LottoCalculator {

    public static final int LOTTO_PRICE = 1_000;

    private final Lottos lottos;

    public LottoCalculator(int amount) {
        this.lottos = Lottos.fromQuantity(amount / LOTTO_PRICE);
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
