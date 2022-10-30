package step3.controller;

import step3.parser.LottoInputParser;
import step3.model.LottoMachine;
import step3.model.LottoNumber;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.view.LottoConsoleView;
import step3.view.LottoOutputView;

import java.util.List;

public class LottoController {


    public void start() {
        int amount = LottoConsoleView.inputPurchasingAmount();

        LottoMachine lottoMachine = new LottoMachine(amount);
        LottosNumberDto lottosNumberDto = lottoMachine.getLottoNumber();
        LottoOutputView.printPurchasingLottos(lottosNumberDto);

        String winningNumber = LottoConsoleView.inputWinningNumber();
        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(winningNumber);
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(lottoNumbers);
        LottoOutputView.printWinStats(lottoResultDto);
    }


    public static void main(String[] args) {
        new LottoController().start();
    }
}
