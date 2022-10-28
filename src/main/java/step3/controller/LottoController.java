package step3.controller;

import step2.StringParser;
import step3.model.Lotto;
import step3.model.LottoFactory;
import step3.model.LottoMachine;
import step3.model.LottoNumber;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottoTicketDto;
import step3.parser.LottoInputParser;
import step3.view.LottoConsoleView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public void start() {
        int amount = LottoConsoleView.printPurchasingAmount();
        List<Lotto> lottos = LottoConsoleView.printPurchasingManual()
                .stream()
                .map(numbers -> StringParser.parseToIntegerArray(numbers))
                .map(integers -> LottoFactory.createLottoByManual(integers))
                .collect(Collectors.toList());

        LottoMachine lottoMachine = new LottoMachine(amount, lottos);
        LottoTicketDto lottoTicketDto = lottoMachine.getLottoNumber();
        LottoConsoleView.printPurchasingLottos(lottoTicketDto);

        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(LottoConsoleView.printWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(LottoConsoleView.printBonusNumber());
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(lottoNumbers, bonusNumber);
        LottoConsoleView.printWinStats(lottoResultDto);
    }

    public static void main(String[] args) {
        new LottoController().start();
    }
}
