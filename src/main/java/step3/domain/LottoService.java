package step3.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step3.enums.Award;

public class LottoService {

    private final static int LOTTO_PRICE = 1000;

    public int calculateLottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public void matchWinningNumbers(List<Lotto> lottos, List<Integer> winningNumbers) {
        lottos.forEach(lotto -> {
            lotto.match(winningNumbers);
        });
    }

    public Map<Integer, Integer> calculateWinningBallsEachLotto(List<Lotto> lottos) {
        Map<Integer, Integer> statistics = initStatistics();

        lottos.forEach(lotto -> {
            statistics.computeIfPresent(lotto.getMatchCount(), (k, v) -> v + 1);
        });
        return statistics;
    }

    public double statisticLottos(Map<Integer, Integer> statistics, int money) {

        double sum = statistics.get(Award.THREE.getCount()) * Award.THREE.getAmount();
        sum += statistics.get(Award.FOUR.getCount()) * Award.FOUR.getAmount();
        sum += statistics.get(Award.FIVE.getCount()) * Award.FIVE.getAmount();
        sum += statistics.get(Award.SIX.getCount()) * Award.SIX.getAmount();
        return Math.floor(sum / money * 100) / 100;
    }

    private Map<Integer, Integer> initStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();

        statistics.put(Award.THREE.getCount(), 0);
        statistics.put(Award.FOUR.getCount(), 0);
        statistics.put(Award.FIVE.getCount(), 0);
        statistics.put(Award.SIX.getCount(), 0);

        return statistics;
    }

    public List<Integer> gainWinnerNumbers(String numbersWithComma) {
        return Arrays.asList(numbersWithComma.split(","))
                .stream()
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }

}
