package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.LottoRandomNumberGenerateStrategy;
import lotto.generator.NumberGenerateStrategy;

public class LottoVendingMachine {
    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final NumberGenerateStrategy strategy;

    public LottoVendingMachine() {
        this.strategy = new LottoRandomNumberGenerateStrategy();
    }

    public LottoTickets purchase(Money from) {
        int quantity = from.divide(LOTTO_TICKET_PRICE);
        return generateLottoTickets(quantity);
    }

    private LottoTickets generateLottoTickets(int quantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoNumbers.add(LottoNumbers.from(strategy));
        }
        return LottoTickets.from(lottoNumbers);
    }
}
