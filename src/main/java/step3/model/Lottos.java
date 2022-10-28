package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getSumOfPriceLottos() {
        return lottos.stream()
                .mapToInt(Lotto::getPrice)
                .sum();
    }

    public List<List<LottoNumber>> getNumbersOfLottos() {
        return lottos.stream()
                .map(lotto -> lotto.getNumbers())
                .collect(Collectors.toList());
    }

    public Map<Rank, Integer> getRankStatsOfLottos(List<Integer> winningNumbers) {
        HashMap<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lottoTicket -> {
            Rank rank = lottoTicket.getRank(winningNumbers);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }
}
