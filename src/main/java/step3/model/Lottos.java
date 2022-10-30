package step3.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;
    private final LottoMoney lottoMoney;
    public Lottos(List<Lotto> lottos, LottoMoney lottoMoney) {
        this.lottos = lottos;
        this.lottoMoney = lottoMoney;
    }

    public int getSumOfPriceLottos() {
        return lottoMoney.getSumOfPriceLottos(lottos.size());
    }

    public List<List<LottoNumber>> getNumbersOfLottos() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public Map<Rank, Integer> getRankOfLottos(List<LottoNumber> winningNumbers) {
        HashMap<Rank, Integer> result = new HashMap<>();
        lottos.forEach(lotto -> {
            Rank rank = lotto.getRank(winningNumbers);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        });
        return result;
    }
}
