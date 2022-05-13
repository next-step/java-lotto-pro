package camp.nextstep.edu.step3;

public class LottoVendingMachine {
    private final int PRICE_PER = 1000;
    private final LottoGenerator generator;

    public LottoVendingMachine(final LottoGenerator generator) {
        this.generator = generator;
    }

    public LottoPaper issued(final int amount) {
        return new LottoPaper(generator.auto(numberOfPurchases(amount)));
    }

    private int numberOfPurchases(final int amount) {
        return amount / PRICE_PER;
    }
}
