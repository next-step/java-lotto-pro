package study.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DivisionResults;

public class Lottos {
    private final List<Lotto> value;

    public Lottos(List<Lotto> lottos) {
        this.value = lottos.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public List<LottoNumbers> lottoNumbers() {
        return value.stream()
                .map(Lotto::numbers)
                .map(LottoNumbers::new)
                .collect(Collectors.toList());
    }

    public DivisionResults findWinnings(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        return new DivisionResults(createDivisionResultList(winningNumber, bonusNumber));
    }

    private List<DivisionResult> createDivisionResultList(LottoNumbers winningNumber, LottoNumber matchBonus) {
        Map<Division, Long> divisionResults = value.stream()
                .map(lotto -> Division.valueOf(lotto.matchCount(winningNumber), lotto.hasNumber(matchBonus)))
                .filter(division -> division != Division.DIVISION_NONE)
                .collect(Collectors.groupingBy(division -> division, Collectors.counting()));

        return divisionResults.entrySet().stream()
                .map(entry -> new DivisionResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
