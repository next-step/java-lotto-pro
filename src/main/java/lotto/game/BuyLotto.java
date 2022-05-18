package lotto.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumbers;

/**
 *
 */
public class BuyLotto {
    private static final int NO_MORE_AVAILABLE_DRAW = 0 ;
    private int budget;
    private int availableDrawCount;
    private final LottoNumbersFactory lottoNumbersFactory;

    private List<LottoNumbers> manuals = new ArrayList<>();
    private List<LottoNumbers> autos = new ArrayList<>();

    public BuyLotto(int budget, LottoNumbersFactory lottoNumbersFactory) {
        this.budget = budget;
        this.availableDrawCount = budget/LottoGame.LOTTO_PRICE;
        this.lottoNumbersFactory = lottoNumbersFactory;
    }

    public void manual(List<Integer> numbers) {
        minusAvailableDrawCount();
        manuals.add(lottoNumbersFactory.createLottoNumbers(numbers));
    }
    public int autoBuyRemainingBudget() {
        int remainingDrawCount = availableDrawCount;
        for(int i=0; i < remainingDrawCount ; i++ ){
            this.auto();
        }
        return remainingDrawCount;
    }

    private void auto() {
        minusAvailableDrawCount();
        autos.add(lottoNumbersFactory.createRandomLottoNumbers());
    }

    private void minusAvailableDrawCount(){
        if(availableDrawCount == NO_MORE_AVAILABLE_DRAW){
            throw new IllegalStateException("예산이 부족하여 더 이상 구매할 수 없습니다.");
        }
        availableDrawCount--;
    }

    public List<LottoNumbers> boughtLottos(){
        List<LottoNumbers> lottos = new ArrayList<>(manuals);
        lottos.addAll(autos);
        return Collections.unmodifiableList(lottos);
    }
}
