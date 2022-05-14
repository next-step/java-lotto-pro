package lotto.game;

import java.util.ArrayList;
import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumbers;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoGame {
    private final int LOTTO_PRICE = 1000;

    private final LottoNumbersFactory lottoNumbersFactory;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoGame(LottoNumbersFactory lottoNumbersFactory, InputView inputView, ResultView resultView) {
        this.lottoNumbersFactory = lottoNumbersFactory;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start(){

        List<LottoNumbers> lottoNumbersList = buyLotto();
//        takeWinNumbers;
//        calculatePrize;
//            printprize
//        calculateYield;
//            printyield
    }

    private List<LottoNumbers> buyLotto(){
        int budget = inputView.takeBudget();
        int drawCount = budget/LOTTO_PRICE;
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for(int i=0; i< drawCount; i++){
            lottoNumbersList.add(lottoNumbersFactory.createRandomLottoNumbers());
        }
        resultView.printBoughtLottos(lottoNumbersList);
        return lottoNumbersList;
    }
}
