package lotto.model;

import lotto.util.Client;
import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoPapersGenerator {

    private final LottoMoney lottoMoney;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPapersGenerator(LottoMoney lottoMoney, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoMoney = lottoMoney;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoPapers getManualLottoPapers() {

        List<LottoPaper> manualLottoPapers = new ArrayList<>();
        InputView.printManualLottoBuyCountInput();
        int manualLottoBuyCount = lottoMoney.buyManualLottoPaper(Client.getLineConsole());

        InputView.printManualLottoNumberInput();

        for (int i = 0; i < manualLottoBuyCount; i++) {
            String manualNumber = Client.getLineConsole();
            manualLottoPapers.add(lottoNumberGenerator.createManualLottoNumber(manualNumber));
        }
        return new LottoPapers(manualLottoPapers);
    }

    public LottoPapers getRandomLottoPapers() {
        int lottoPaperCount = lottoMoney.getLottoPaperCount();
        return LottoPapers.createLottoPapers(lottoPaperCount);
    }
}
