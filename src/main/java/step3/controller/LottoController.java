package step3.controller;

import step3.io.Console;
import step3.io.LottoInputParser;
import step3.model.LottoNumber;
import step3.model.LottoMachine;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoController {


    public void start() {
        InputView.printPurchasingAmount();
        int amount = Console.readInt();
        LottoMachine lottoMachine = new LottoMachine(amount);
        LottosNumberDto lottosNumberDto = lottoMachine.getLottoNumber();
        ResultView.printPurchasingLottos(lottosNumberDto);
        InputView.printWinningNumber();
        String winningNumber = Console.readLine();
        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(winningNumber);
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(lottoNumbers);
        ResultView.printWinStats(lottoResultDto);
    }


    public static void main(String[] args) {
        new LottoController().start();
    }
}
