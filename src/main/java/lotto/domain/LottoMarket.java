package lotto.domain;

import generator.LottoNumberGenerator;
import generator.NumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class LottoMarket {
    private final NumberGenerator numberGenerator;

    public LottoMarket() {
        this.numberGenerator = new LottoNumberGenerator();
    }

    public LottoTicket purchaseAutoLottoTicket(Money money,
        LottoCount manualLottoCount) {
        LottoCount lottoCount = money.calculateLottoCount();
        return LottoTicket.from(generateAutoLottoNumbers(lottoCount.minus(manualLottoCount)));
    }

    public LottoTicket purchaseManualLottoTicket(List<LottoNumbers> manualLottoNumbers) {
        return LottoTicket.from(manualLottoNumbers);
    }

    private List<LottoNumbers> generateAutoLottoNumbers(LottoCount lottoCount) {
        List<LottoNumbers> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(LottoNumbers.generateBy(this.numberGenerator));
        }
        return lottos;
    }
}
