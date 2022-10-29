package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final int payAmount;
    List<Lotto> lottos = new ArrayList<>();
    private LottoResult lottoResult;

    public LottoGame(int payAmount){
        this.payAmount = payAmount;
        int lottoAmount = calculateLottoAmount();
        OutputView.printLottoAmount(lottoAmount);

        for(int i=0; i<lottoAmount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputView.printLottos(lotto);
        }
    }

    public int calculateLottoAmount(){
        return payAmount/1000;
    }

    public void findWinner(List<Integer> winnerNumbers){
        lottoResult = new LottoResult(lottos.size());
        for(Lotto lotto : lottos){
            int collectNumber = lotto.countCollectNumber(winnerNumbers);
            lottoResult.putLottoResult(collectNumber);
        }
    }

    public void printResult(){
        OutputView.printLottoResult(lottoResult);
    }
}