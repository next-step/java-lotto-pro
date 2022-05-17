package Lotto;

import Lotto.enums.CompareEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<CompareEnum, Integer> hitList = new HashMap<>();
    private Yield yield;

    public Map<CompareEnum, Integer> getHitList() {
        return hitList;
    }

    public Yield getYield() {
        return yield;
    }

    public LottoResult() {
    }

    public void counting(CompareEnum result) {
       CompareEnum.valuesExcludeNone()
                    .stream()
                    .filter(compareEnum -> compareEnum == result)
                    .forEach(compareEnum ->  hitList.put(compareEnum, hitList.getOrDefault(compareEnum, 0) + 1));
    }

    public void calculationYield(PurchaseMoney purchaseMoney) {
        yield = new Yield(purchaseMoney.getMoney());
        yield.yieldCalcution(hitList);
    }
}
