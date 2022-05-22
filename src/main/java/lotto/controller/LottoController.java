package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoLine;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.service.LottoService;
import lotto.util.LottoStringGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
        this.lottoService = new LottoService();
    }

    public void run(){
        LottoPayment lottoPayment = inputLottoPayment();
        LottoGame lottoGame = buyLotto(lottoPayment);
        LottoLine winLottoLine = inputWinInformation();
        printResult(lottoGame, winLottoLine, lottoPayment);
    }

    private LottoPayment inputLottoPayment(){
        return new LottoPayment(InputView.inputTotalPayment());
    }

    private LottoGame buyLotto(LottoPayment lottoPayment){
        LottoGame lottoGame = lottoService.buyLotto(lottoPayment);
        outputView.printPayment(lottoGame.toLottoGameDTO());
        return lottoGame;
    }

    private LottoLine inputWinInformation(){
        return LottoStringGenerator.toWinLottoLine(InputView.inputLastWeekWinningLottoLine());
    }

    private void printResult(LottoGame lottoGame, LottoLine winLottoLine, LottoPayment lottoPayment){
        LottoResult lottoResult = lottoService.getLottoResult(lottoGame, winLottoLine);
        LottoPayment prize = new LottoPayment(lottoResult.getLottoPrize());
        outputView.printLottoResult(outputView.getLottoResultString(lottoResult));
        outputView.printEarningRate(outputView.getEarningRateString(lottoPayment.toLottoPaymentDTO(), prize.toLottoPaymentDTO()));
    }
}
