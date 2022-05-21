package lotto.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.factory.LottoNumbersFactory;
import lotto.number.LottoNumbers;

public class BuyLotto {
    private static final int NO_MORE_AVAILABLE_DRAW = 0;
    private final LottoNumbersFactory lottoNumbersFactory;
    private int budget;
    private int availableDrawCount;
    private List<LottoNumbers> manuals = new ArrayList<>();
    private List<LottoNumbers> autos = new ArrayList<>();

    public BuyLotto(int budget, LottoNumbersFactory lottoNumbersFactory) {
        this.budget = budget;
        this.availableDrawCount = budget / LottoGame.LOTTO_PRICE;
        this.lottoNumbersFactory = lottoNumbersFactory;
    }

    public void manual(List<Integer> numbers) {
        if(isAvailableBuy()){
            manuals.add(lottoNumbersFactory.createLottoNumbers(numbers));
        }
    }

    private boolean isAvailableBuy(){
        if(calculateAvailableDrawCount() <= NO_MORE_AVAILABLE_DRAW){
            throw new IllegalStateException("예산이 부족하여 더 이상 구매할 수 없습니다.");
        }
        return true;
    }

    private int calculateAvailableDrawCount(){
        return availableDrawCount - manuals.size();
    }

    public int autoBuyRemainingBudget() {
        int autoDrawCount = calculateAvailableDrawCount();
        for (int i = 0; i < autoDrawCount; i++) {
            this.auto();
        }
        return autoDrawCount;
    }

    private void auto() {
        if(isAvailableBuy()){
            autos.add(lottoNumbersFactory.createRandomLottoNumbers());
        }
    }

    public void checkBudget(int manualBuyCount) {
        if (manualBuyCount > availableDrawCount) {
            throw new IllegalStateException("예산이 부족하여 더 이상 구매할 수 없습니다.");
        }
    }

    public List<LottoNumbers> boughtLottos() {
        List<LottoNumbers> lottos = new ArrayList<>(manuals);
        lottos.addAll(autos);
        return Collections.unmodifiableList(lottos);
    }
}
