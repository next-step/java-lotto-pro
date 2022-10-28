package step3.controller;

import step2.StringParser;
import step3.io.Console;
import step3.model.LottoService;
import step3.model.Lottos;
import step3.model.dto.LottosNumberDto;
import step3.view.InputView;
import step3.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class LottoController {


    public void start(){
        InputView.printPurchasingAmount();
        int amount = Console.readInt();
        LottoService lottoService = new LottoService(amount);
        LottosNumberDto lottosNumberDto = lottoService.getLottoTicketState();
        ResultView.printPurchasingLottos(lottosNumberDto);
        InputView.printWinningNumber();
        List<Integer> winningNumbers = StringParser.parseToIntegerArray(Console.readLine());
        ResultView.printWinStats(lottoService.getRankStatus(winningNumbers));
    }


    public static void main(String[]args){
        new LottoController().start();
    }
}
