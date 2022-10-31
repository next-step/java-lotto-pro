package step3.model.lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {

    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Integer> getResults(Lotto winningLotto) {
        return lottoList.stream().map(lotto -> lotto.getMatchCount(winningLotto)).collect(Collectors.toList());
    }

    public List<String> getLottoListString(){
        return lottoList.stream().map(Lotto::toString).collect(Collectors.toList());
    }


}
