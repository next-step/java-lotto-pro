package Lotto;

import Lotto.enums.CompareEnum;

public class LottoResult {
    private int firstCount;
    private int secondCount;
    private int thirdCount;
    private int fourthCount;
    private Yield yield;

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

    public LottoResult() {
    }

    public LottoResult(int firstCount, int secondCount, int thirdCount, int fourthCount) {
        this.firstCount = firstCount;
        this.secondCount = secondCount;
        this.thirdCount = thirdCount;
        this.fourthCount = fourthCount;
    }

    public void counting(CompareEnum result) {
        if(result == CompareEnum.First)
            firstCount++;

        if(result == CompareEnum.Second)
            secondCount++;

        if(result == CompareEnum.Third)
            thirdCount++;

        if(result == CompareEnum.Fourth)
            fourthCount++;
    }

    public void calculationYield(PurchaseMoney purchaseMoney) {
        yield = new Yield(purchaseMoney.getMoney());
        yield.yieldCalcution(this);
    }
}
