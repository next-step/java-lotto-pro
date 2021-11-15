package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Statics {

    private final Money money;
    private final LottoNumbersGroup lottoNumbersGroup;
    private final Map<Rank, Count> matchCounter;

    private double profitRate;

    public Statics(Money money, LottoNumbersGroup group) {
        this.money = money;
        this.lottoNumbersGroup = group;
        this.matchCounter = new HashMap<>();
        initMatchCounter();
        analyst();
        calculateProfitRate();
    }

    public Statics(Money money) {
        this.money = money;
        this.lottoNumbersGroup = null;
        this.matchCounter = new HashMap<>();
        initMatchCounter();
    }

    public static Statics valueOf(Money userInputMoney, LottoNumbersGroup lottoNumbersGroup) {
        return new Statics(userInputMoney, lottoNumbersGroup);
    }

    private void initMatchCounter() {
        for(Rank rank : Rank.values()) {
            matchCounter.put(rank, new Count());
        }
    }

    public void analyst() {
        LottoNumbers lastLottoNumbers = lottoNumbersGroup.getWinningLottoNumbers();
        for(LottoNumbers lottoNumbers : lottoNumbersGroup.getLottoNumbersList()) {
            Rank matchResult = lastLottoNumbers.match(lottoNumbers, lottoNumbersGroup.getBonusBall());
            renewMatchCounter(matchResult);
        }
    }

    private void renewMatchCounter(Rank matchResult) {
        Count count = matchCounter.get(matchResult);
        matchCounter.put(matchResult, count.increase());
    }

    public void calculateProfitRate() {
        int totalPrize = 0;
        for (Rank rank : Rank.values()) {
            totalPrize += matchCounter.get(rank).getCount() * rank.getWinningMoney();
        }
        profitRate = Math.floor((double) totalPrize/money.getMoney()*100)/100;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public Map<Rank, Count> getMatchCounter() {
        return matchCounter;
    }
}
