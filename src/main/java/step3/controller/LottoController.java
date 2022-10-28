package step3.controller;

import step3.io.Console;
import step3.io.LottoInputParser;
import step3.model.LottoNumber;
import step3.model.LottoService;
import step3.model.dto.LottosNumberDto;
import step3.view.InputView;
import step3.view.ResultView;

import java.util.List;

public class LottoController {


    public void start() {
        InputView.printPurchasingAmount();
        int amount = Console.readInt();
        LottoService lottoService = new LottoService(amount);
        LottosNumberDto lottosNumberDto = lottoService.getLottoTicketState();
        ResultView.printPurchasingLottos(lottosNumberDto);
        InputView.printWinningNumber();
        String winningNumber = Console.readLine();
        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(winningNumber);
        ResultView.printWinStats(lottoService.getRankStatus(lottoNumbers));
    }


    public static void main(String[] args) {
        new LottoController().start();
    }
}
