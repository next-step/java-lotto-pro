package step3.domain;

import java.util.Map;
import step3.enums.Award;

public class LottoService {

    private final static int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public double statisticLottos(Map<Integer, Integer> statistics, int money) {

        double sum = statistics.get(Award.THREE.getCount()) * Award.THREE.getAmount();
        sum += statistics.get(Award.FOUR.getCount()) * Award.FOUR.getAmount();
        sum += statistics.get(Award.FIVE.getCount()) * Award.FIVE.getAmount();
        sum += statistics.get(Award.FIVE.getCount() + Award.BONUS.getCount()) * Award.BONUS.getAmount();
        sum += statistics.get(Award.SIX.getCount()) * Award.SIX.getAmount();
        return Math.floor(sum / money * 100) / 100;
    }


}
