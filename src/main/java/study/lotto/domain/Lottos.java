package study.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DivisionResults;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<LottoNumbers> lottoNumbers() {
        return lottoList.stream().map(Lotto::numbers).map(LottoNumbers::new).collect(Collectors.toList());
    }

    public DivisionResults findWinnings(LottoNumbers winningNumber) {
        return new DivisionResults(createDivisionResultList(winningNumber));
    }

    private List<DivisionResult> createDivisionResultList(LottoNumbers winningNumber) {
        Map<Division, Long> divisionResults = lottoList.stream()
                .map(lotto -> lotto.checkResult(winningNumber))
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(division -> division, Collectors.counting()));

        return divisionResults.entrySet().stream()
                .map(entry -> new DivisionResult(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
