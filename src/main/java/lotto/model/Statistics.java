package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Rank, Integer> resultMap = new HashMap() {{
        put(new Rank(3L), 0);
        put(new Rank(4L), 0);
        put(new Rank(5L), 0);
        put(new Rank(6L), 0);
    }};

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

    public Statistics(Lotto win, List<Lotto> lottos) {
        lottos.forEach(lotto -> compareNumber(win, lotto));
    }

    private void compareNumber(Lotto win, Lotto lotto) {
        long count = lotto.getLottoNumber().stream()
                .filter(lottoNumber -> win.getLottoNumber().contains(lottoNumber))
                .count();

        resultMap.computeIfPresent(new Rank(count), (k, v) -> Math.toIntExact(v + 1));
    }
}
