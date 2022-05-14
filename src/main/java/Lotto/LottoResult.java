package Lotto;

import Lotto.enums.CompareEnum;

public class LottoResult {
    int firstCount;
    int secondCount;
    int thirdCount;
    int fourthCount;
    Yield yield;

    public int getFirstCount() {
        return firstCount;
    }

    public int getSecondCount() {
        return secondCount;
    }

    public int getThirdCount() {
        return thirdCount;
    }

    public int getFourthCount() {
        return fourthCount;
    }

    public Yield getYield() {
        return yield;
    }

    void counting(CompareEnum result) {
        if(result == CompareEnum.First)
            firstCount++;

        if(result == CompareEnum.Second)
            secondCount++;

        if(result == CompareEnum.Third)
            thirdCount++;

        if(result == CompareEnum.Fourth)
            fourthCount++;
    }

    void calculationYield(PurchaseMoney purchaseMoney) {
        yield = new Yield(purchaseMoney.getMoney());
        yield.yieldCalcution(this);
    }
}
