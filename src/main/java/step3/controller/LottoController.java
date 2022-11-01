package step3.controller;

import step3.model.*;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.parser.LottoInputParser;
import step3.view.LottoConsoleView;
import step3.view.LottoOutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    public void start() {

        int amount = LottoConsoleView.inputPurchasingAmount();
        int manualCount = LottoConsoleView.inputPurchaseManualCount();
        LottoMoney purchaseMoney = new LottoMoney(amount,manualCount);
        List<Lotto> manualLottos = LottoFactory.createLottosByManual(LottoConsoleView.inputPurchaseManual(manualCount));
        List<Lotto> autoLottos = LottoFactory.createLottosByAuto(purchaseMoney);

        Lottos lottos = new Lottos(Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList()));

        LottoMachine lottoMachine = new LottoMachine(purchaseMoney, lottos);

        LottosNumberDto lottoTicketDto = lottoMachine.getLottoNumber();
        LottoOutputView.printPurchasingLottos(lottoTicketDto);

        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(LottoConsoleView.inputWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(LottoConsoleView.inputBonusNumber());
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new WinningLotto(new Lotto(lottoNumbers), bonusNumber));
        LottoOutputView.printWinStats(lottoResultDto);
    }

    public static void main(String[] args) {
        new LottoController().start();
    }
}
