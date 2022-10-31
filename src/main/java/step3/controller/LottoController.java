package step3.controller;

import step2.StringParser;
import step3.model.*;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.parser.LottoInputParser;
import step3.view.LottoConsoleView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public void start() {
        int amount = LottoConsoleView.inputPurchasingAmount();
        List<Lotto> lottos = LottoFactory.createLottoByManual(LottoConsoleView.inputPurchaseManual());

        LottoMachine lottoMachine = new LottoMachine(new LottoMoney(amount), new Lottos(lottos));
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
