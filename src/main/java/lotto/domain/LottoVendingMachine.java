package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.LottoRandomNumberGenerateStrategy;
import lotto.domain.generator.NumberGenerateStrategy;

public class LottoVendingMachine {

    private final NumberGenerateStrategy strategy;

    public LottoVendingMachine() {
        this.strategy = new LottoRandomNumberGenerateStrategy();
    }

    public LottoTickets purchase(Money money) {
        int quantity = money.getQuantityFromMoney();
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
