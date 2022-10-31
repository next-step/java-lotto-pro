package step3.controller;

import step3.model.*;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.parser.LottoInputParser;
import step3.view.LottoConsoleView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    public void start() {
        LottoMoney lottoMoney = new LottoMoney(LottoConsoleView.inputPurchasingAmount());
        List<Lotto> manualLottos = LottoFactory.createLottosByManual(LottoConsoleView.inputPurchaseManual());
        List<Lotto> autoLottos = LottoFactory.createLottosByAuto(new LottoMoney(lottoMoney.getRemainMoney(manualLottos)));
        Lottos lottos = new Lottos(Stream.concat(manualLottos.stream(), autoLottos.stream()).collect(Collectors.toList()));
        LottoMachine lottoMachine = new LottoMachine(lottoMoney, lottos);

        LottosNumberDto lottoTicketDto = lottoMachine.getLottoNumber();
        LottoConsoleView.printPurchasingLottos(lottoTicketDto);

        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(LottoConsoleView.inputWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(LottoConsoleView.inputBonusNumber());
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(new WinningLotto(new Lotto(lottoNumbers), bonusNumber));
        LottoConsoleView.printWinStats(lottoResultDto);
    }

    public static void main(String[] args) {
        new LottoController().start();
    }
}
