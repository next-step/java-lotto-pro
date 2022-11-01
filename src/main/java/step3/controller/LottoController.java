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
        LottoMoney purchaseMoney = new LottoMoney(LottoConsoleView.inputPurchasingAmount());
        List<Lotto> manualLottos = LottoFactory.createLottosByManual(LottoConsoleView.inputPurchaseManual());
        LottoMoney remainMoney = new LottoMoney(purchaseMoney.getRemainMoney(manualLottos));
        List<Lotto> autoLottos = LottoFactory.createLottosByAuto(remainMoney);

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