package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private final LottoResult lottoResult;

    public Lottos(int lottoAmount){
        lottos = new ArrayList<>();
        for(int i=0; i<lottoAmount; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            OutputView.printLottos(lotto);
        }
        lottoResult = new LottoResult(lottos.size());
    }

    public void findWinner(Lotto winningNumbers) {
        for(Lotto lotto : lottos){
            int collectNumber = lotto.countCollectNumber(winningNumbers);
            lottoResult.putLottoResult(collectNumber);
        }
    }

    public void printLottoResult(){
        OutputView.printLottoResult(lottoResult);
    }
}
