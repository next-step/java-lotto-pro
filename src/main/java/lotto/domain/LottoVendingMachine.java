package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.common.LottoQuantity;
import lotto.domain.generator.RandomLottoNumbersGenerateStrategy;
import lotto.domain.generator.LottoNumbersGenerateStrategy;

public class LottoVendingMachine {

    private final LottoNumbersGenerateStrategy strategy;

    public LottoVendingMachine() {
        this.strategy = new RandomLottoNumbersGenerateStrategy();
    }

    public PurchasedLottoTickets purchase(LottoQuantity manualLottoQuantity, List<LottoNumbers> manualLottoNumbersList) {

        PurchasedLottoTickets autoLottoTickets = generateLottoTickets(manualLottoQuantity.getAutoLottoQuantity());
        return autoLottoTickets.merge(manualLottoNumbersList);
    }

    private PurchasedLottoTickets generateLottoTickets(int quantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoNumbers.add(LottoNumbers.from(strategy));
        }
        return PurchasedLottoTickets.from(lottoNumbers);
    }
}
