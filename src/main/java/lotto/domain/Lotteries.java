package lotto.domain;

import java.util.*;

public class Lotteries {

    public static final int LOTTO_AMOUNT = 1000;
    public static final int LOTTO_MAX_BUY_AMOUNT = 2000000000;

    private List<Lotto> lotteries;

    public Lotteries(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public Lotteries(int buyAmount) {
        int lottoCount = buyAmount/LOTTO_AMOUNT ;
        this.lotteries = new ArrayList<>();
        while(lottoCount-->0) {
            lotteries.add(new Lotto());
        }
    }

    public Map<Lotto, Integer> getLottoMatchNumberMap(int[] winningNumbers) {
        Map<Lotto,Integer> lottoMatchNumberMap = new HashMap<>();
        for(Lotto lotto : lotteries) {
            lottoMatchNumberMap.put(lotto, lotto.getMatchNumber(winningNumbers));
        }
        return lottoMatchNumberMap;
    }

    @Override
    public String toString() {
        String result = lotteries.size() + "개를 구매했습니다.\n";
        for(Lotto lotto : lotteries) {
            result += (lotto + "\n");
        }
        return result;
    }
}
