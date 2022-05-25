package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoLine;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPayment;
import lotto.domain.LottoResult;
import lotto.exception.LottoCountException;
import lotto.exception.LottoPaymentException;
import lotto.exception.LottoStringFormatException;
import lotto.exception.NotNumberException;
import lotto.service.LottoService;
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

        LottoCount manualLottoCount = getManualLottoCount(lottoPayment);
        LottoGame manualLottoGame = getManualLottoGame(manualLottoCount);

        LottoGame autoLottoGame = buyAutoLotto(lottoPayment, manualLottoCount);
        LottoGame joinedLottoGame = lottoService.joinLottoGame(manualLottoGame, autoLottoGame);
        outputView.printPayment(joinedLottoGame.toLottoGameDTO(), manualLottoCount);

        LottoLine winLottoLine = inputLastWeekWinningLottoLine();
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());
        printResult(joinedLottoGame, winLottoLine, lottoPayment, bonusNumber);
    }

    private LottoPayment inputLottoPayment(){
        try{
            return new LottoPayment(InputView.inputTotalPayment());
        }catch (LottoPaymentException e){
            System.out.println(e.getMessage());
            return inputLottoPayment();
        }
    }

    private LottoCount getManualLottoCount(LottoPayment lottoPayment){
        try{
            LottoCount manualLottoCount = new LottoCount(InputView.inputManualCount());
            lottoService.validateManualLottoCount(lottoPayment, manualLottoCount);
            return manualLottoCount;
        }catch (LottoCountException e){
            System.out.println(e.getMessage());
            return getManualLottoCount(lottoPayment);
        }
    }

    private LottoGame getManualLottoGame(LottoCount manualLottoCount){
        try{
            InputView.inputManualLottoLines();
            LottoGame manualLottoGame = lottoService.getManualLottoGame(manualLottoCount);
            return manualLottoGame;
        }catch (LottoStringFormatException e){
            System.out.println(e.getMessage());
            return getManualLottoGame(manualLottoCount);
        }
    }

    private LottoGame buyAutoLotto(LottoPayment lottoPayment, LottoCount manualLottoCount){
        LottoGame autoLottoGame = lottoService.buyAutoLotto(lottoPayment, manualLottoCount);
        return autoLottoGame;
    }

    private LottoLine inputLastWeekWinningLottoLine(){
        try{
            return lottoService.inputLastWeekWinningLottoLine();
        }catch (LottoStringFormatException e){
            System.out.println(e.getMessage());
            return inputLastWeekWinningLottoLine();
        }
    }

    private void printResult(LottoGame lottoGame, LottoLine winLottoLine, LottoPayment lottoPayment, LottoNumber bonusNumber){
        LottoResult lottoResult = lottoService.getLottoResult(lottoGame, winLottoLine, bonusNumber);
        LottoPayment prize = new LottoPayment(lottoResult.getLottoPrize());
        outputView.printLottoResult(outputView.getLottoResultString(lottoResult));
        outputView.printEarningRate(outputView.getEarningRateString(lottoPayment.toLottoPaymentDTO(), prize.toLottoPaymentDTO()));
    }
}
