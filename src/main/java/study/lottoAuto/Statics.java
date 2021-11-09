package study.lottoAuto;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Statics {

    private final int COUNT_BASE = 3;

    private final Map<Rank, Count> resultMap = new HashMap<>();
    private final Map<Rank, Prize> prizeMap = new HashMap<>();

    private Money money;
    private LottoNumbersGroup lottoNumbersGroup;
    private LottoNumbers lastLottoNumbers;
    private double profitRate;

    public Statics() {
        resultMap.put(new Rank(3), new Count());
        resultMap.put(new Rank(4), new Count());
        resultMap.put(new Rank(5), new Count());
        resultMap.put(new Rank(6), new Count());

        prizeMap.put(new Rank(3), new Prize(5_000));
        prizeMap.put(new Rank(4), new Prize(50_000));
        prizeMap.put(new Rank(5), new Prize(1_500_000));
        prizeMap.put(new Rank(6), new Prize(2_000_000_000));
    }

    public Statics(Money money) {
        this();
        this.money = money;
    }

    public Statics(Money money, LottoNumbersGroup group, LottoNumbers last) {
        this();
        this.money = money;
        this.lottoNumbersGroup = group;
        this.lastLottoNumbers = last;
    }

    public void analyst() {
        for(LottoNumbers lottoNumbers : lottoNumbersGroup.getLottoNumbersList()) {
            writeResult(lastLottoNumbers.getMatchCount(lottoNumbers));
        }
        calculateProfitRate();
    }

    private void writeResult(final int result) {
        if(result >= COUNT_BASE) {
            renew(result);
        }
    }

    public void renew(int result) {
        Count count = resultMap.get(new Rank(result));
        count.increase();
        resultMap.put(new Rank(result), count);
    }

    public void calculateProfitRate() {
        int totalPrize = 0;
        for (Map.Entry<Rank, Count> entry : resultMap.entrySet()) {
            totalPrize += entry.getValue().getCount() * prizeMap.get(entry.getKey()).getPrize();
        }
        profitRate = Math.floor((double) totalPrize/money.getMoney()*100)/100;
    }

    public String makeStaticPrintFormat() {
        StringBuilder sb = new StringBuilder();

        Iterator<Rank> iterator = resultMap.keySet().iterator();
        while(iterator.hasNext()){
            Rank rank = iterator.next();
            Count count = resultMap.get(rank);

            String line = String.format("%d개 일치 (%d원)- %d개\n", rank.getRank(), prizeMap.get(rank).getPrize(), count.getCount());
            sb.append(line);
        }
        return sb.toString();
    }

    public String makeProfitPrintFormat() {
        return String.format("총 수익률은 %.2f입니다.", profitRate);
    }

    public double getProfitRate() {
        return profitRate;
    }
}
