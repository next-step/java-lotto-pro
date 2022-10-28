package step3.controller;

import step3.parser.LottoInputParser;
import step3.model.LottoMachine;
import step3.model.LottoNumber;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.view.LottoConsoleView;

import java.util.List;

public class LottoController {


    public void start() {
        int amount = LottoConsoleView.printPurchasingAmount();

        LottoMachine lottoMachine = new LottoMachine(amount);
        LottosNumberDto lottosNumberDto = lottoMachine.getLottoNumber();
        LottoConsoleView.printPurchasingLottos(lottosNumberDto);

        String winningNumber = LottoConsoleView.printWinningNumber();
        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(winningNumber);
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(lottoNumbers);
        LottoConsoleView.printWinStats(lottoResultDto);
    }


    public static void main(String[] args) {
        new LottoController().start();
    }
}
