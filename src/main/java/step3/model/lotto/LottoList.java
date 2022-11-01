package step3.model.lotto;

import java.util.List;
import java.util.stream.Collectors;
import step3.model.machine.Results;

public class LottoList {

    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Results getMatchResults(WinningLotto winningLotto) {
        Results results = new Results();
        lottoList.forEach(lotto -> results.recordResult(winningLotto.getMatchResult(lotto)));
        return results;
    }

    public int getLottoListSize(){
        return lottoList.size();
    }

    public List<String> getLottoListString(){
        return lottoList.stream().map(Lotto::toString).collect(Collectors.toList());
    }

}
