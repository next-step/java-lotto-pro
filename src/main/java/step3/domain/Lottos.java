package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import step3.enums.Award;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> generateLottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public void matchWinningNumbers(String numbersWithComma) {
        List<Integer> winningNumbers = this.gainWinnerNumbers(numbersWithComma);
        lottos.forEach(lotto -> {
            lotto.match(winningNumbers);
        });
    }

    public Map<Integer, Integer> calculateWinningBallsEachLotto() {
        Map<Integer, Integer> statistics = initStatistics();

        lottos.forEach(lotto -> {
            statistics.computeIfPresent(lotto.getMatchCount(), (k, v) -> v + 1);
        });
        return statistics;
    }

    private Map<Integer, Integer> initStatistics() {
        Map<Integer, Integer> statistics = new HashMap<>();

        statistics.put(Award.THREE.getCount(), 0);
        statistics.put(Award.FOUR.getCount(), 0);
        statistics.put(Award.FIVE.getCount(), 0);
        statistics.put(Award.SIX.getCount(), 0);

        return statistics;
    }

    private List<Integer> gainWinnerNumbers(String numbersWithComma) {
        return Arrays.asList(numbersWithComma.split(","))
                .stream()
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
    }
}
