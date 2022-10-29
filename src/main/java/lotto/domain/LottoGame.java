package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
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
        return payAmount/LOTTO_PRICE;
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