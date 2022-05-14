package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public static final int PRICE = 1000;
    private final List<LottoNumberSet> numberSets;

    public LottoTicket(final int money) {
        validate(money);
        List<LottoNumberSet> numberSets = new ArrayList<>();
        for (int i = 0; i < money / PRICE; i++) {
            numberSets.add(new LottoNumberSet(LottoNumbersGenerator.generate(1, 45, 6)));
        }
        this.numberSets = numberSets;
    }

    public int size() {
        return numberSets.size();
    }

    private void validate(final int money) {
        if (money / PRICE <= 0) {
            throw new IllegalArgumentException("잘못된 금액");
        }
    }
}
