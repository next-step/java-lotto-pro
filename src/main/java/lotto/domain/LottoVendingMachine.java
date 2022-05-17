package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.RandomLottoNumbersGenerateStrategy;
import lotto.domain.generator.LottoNumbersGenerateStrategy;

public class LottoVendingMachine {

    private final LottoNumbersGenerateStrategy strategy;

    public LottoVendingMachine() {
        this.strategy = new RandomLottoNumbersGenerateStrategy();
    }

    public PurchasedLottoTickets purchase(InputLottoInformation lottoInformation) {
        PurchasedLottoTickets autoLottoTickets = generateLottoTickets(lottoInformation.autoLottoCount());
        return autoLottoTickets.merge(lottoInformation.getManualLottoNumbersList());
    }

    private PurchasedLottoTickets generateLottoTickets(int quantity) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoNumbers.add(LottoNumbers.from(strategy));
        }
        return PurchasedLottoTickets.from(lottoNumbers);
    }
}
