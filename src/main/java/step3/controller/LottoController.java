package step3.controller;

import step3.model.*;
import step3.model.dto.LottoResultDto;
import step3.model.dto.LottosNumberDto;
import step3.parser.LottoInputParser;
import step3.view.LottoConsoleView;
import step3.view.LottoOutputView;

import java.util.List;

public class LottoController {

    public void start() {
        int price = LottoConsoleView.inputPurchasingAmount();
        LottoMoney lottoMoney = new LottoMoney(price);

        LottoMachine lottoMachine = new LottoMachine(lottoMoney,new Lottos(LottoFactory.createLottos(lottoMoney)));
        LottosNumberDto lottosNumberDto = lottoMachine.getLottoNumber();
        LottoOutputView.printPurchasingLottos(lottosNumberDto);

        List<LottoNumber> lottoNumbers = LottoInputParser.parseToLottoNumberArray(LottoConsoleView.inputWinningNumber());
        LottoNumber bonusNumber = LottoNumber.valueOf(LottoConsoleView.inputBonusNumber());
        LottoResultDto lottoResultDto = lottoMachine.getLottoResult(lottoNumbers, bonusNumber);
        LottoOutputView.printWinStats(lottoResultDto);
    }

    public static void main(String[] args) {
        new LottoController().start();
    }
}
