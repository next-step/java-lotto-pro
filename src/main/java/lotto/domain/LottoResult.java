package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    public static final int[] PRIZE_MONEY = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private final HashMap<Integer, Integer> lottoResult;
    private final int lottoAmount;

    public LottoResult(int lottoAmount){
        lottoResult = new HashMap<>();
        this.lottoAmount = lottoAmount;
    }

    public void putLottoResult(int collectNumberCnt){
        lottoResult.put(collectNumberCnt, getLottoResult(collectNumberCnt)+1);
    }

    public int getLottoResult(int collectNumberCnt){
        return lottoResult.getOrDefault(collectNumberCnt, 0);
    }

    public double calculateProfitRatio(){
        double profit = 0;
        for(int i=3; i<PRIZE_MONEY.length; i++){
            profit += getLottoResult(i) * PRIZE_MONEY[i];
        }

        return Math.floor(profit / (lottoAmount*1000) * 100)/100;
    }
}
