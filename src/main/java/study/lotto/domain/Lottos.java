package study.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DrawResult;

public class Lottos {
    private final List<Lotto> value;

    public Lottos(List<Lotto> lottos) {
        this.value = copy(lottos);
    }

    public List<Lotto> get() {
        return copy(value);
    }

    public DrawResult findWinnings(Lotto winningNumber, LottoNumber bonusNumber) {
        return new DrawResult(createDivisionResultList(winningNumber, bonusNumber));
    }

    private List<DivisionResult> createDivisionResultList(Lotto winningNumber, LottoNumber matchBonus) {
        Map<Division, Long> divisionResults = value.stream()
                .map(lotto -> Division.valueOf(winningNumber.matchCount(lotto), lotto.has(matchBonus)))
                .collect(Collectors.groupingBy(division -> division, Collectors.counting()));

        return divisionResults.entrySet().stream()
                .map(entry -> new DivisionResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    private List<Lotto> copy(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
