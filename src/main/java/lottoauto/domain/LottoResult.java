package lottoauto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    public static final int MIN_CONTAIN_COUNT = 3;
    public static final int ZERO = 0;
    private Map<Integer, Integer> result;
    private LottoWinningMoney lottoWinningMoney;

    public LottoResult(){
        result = new HashMap<>();
        lottoWinningMoney = new LottoWinningMoney();
    }

    public void addLottoResult(int containNumberCount) {
        if(isValidateMinContainCount(containNumberCount)){
            return;
        }

        result.put(containNumberCount, result.getOrDefault(containNumberCount, ZERO) + 1);
    }

    public int getResultCount(int containNumberCount) {
        return result.getOrDefault(containNumberCount, ZERO);
    }

    private boolean isValidateMinContainCount(int containNumberCount){
        return containNumberCount < MIN_CONTAIN_COUNT;
    }

    public int calculateWinningMoney() {
        return lottoWinningMoney.calculateWinningMoney(result);
    }

    public Map<Integer, Integer> getWinningMoneyTable() {
        return lottoWinningMoney.getWinningMoneyTable();
    }
}
