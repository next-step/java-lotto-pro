package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.module.AutoGenerator;
import lotto.module.ManualGenerator;
import lotto.module.NumberGeneratorStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.view.ConsoleView.*;

public final class LottoController {

    public LottoController() {
    }

    public BoughtLotto buyLotto() {
        try {
            return BoughtLotto.of(enterMoney(), enterManualCount());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return buyLotto();
        }
    }

    public LottoTicket generateLottoTicket(BoughtLotto boughtLotto) {
        printManualLottoNumber();
        try {
            List<LottoNumbers> lottoNumberList = new ArrayList<>();
            lottoNumberList.addAll(generateLottoNumbers(generateManualLottoNumbers(boughtLotto)));
            lottoNumberList.addAll(generateLottoNumbers(generateAutoLottoNumbers(boughtLotto)));
            return new LottoTicket(lottoNumberList);
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return generateLottoTicket(boughtLotto);
        }
    }

    private NumberGeneratorStrategy generateManualLottoNumbers(BoughtLotto boughtLotto) {
        return new ManualGenerator(
                IntStream.range(0, boughtLotto.getManualCount())
                        .mapToObj(i -> enterManualLottoNumber())
                        .collect(Collectors.toList())
        );
    }

    private NumberGeneratorStrategy generateAutoLottoNumbers(BoughtLotto boughtLotto) {
        return new AutoGenerator(boughtLotto.getAutoCount());
    }

    private List<LottoNumbers> generateLottoNumbers(NumberGeneratorStrategy strategy) {
        return strategy.createLottos();
    }

    public LottoNumbers enterWinningLottoNumbers() {
        try {
            return LottoNumbers.fromString(enterWinning());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return enterWinningLottoNumbers();
        }
    }

    public Winning enterWinningBonusNumber(LottoNumbers winningNumbers) {
        try {
            return Winning.of(winningNumbers, enterBonusNumber());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return enterWinningBonusNumber(winningNumbers);
        }
    }
}
