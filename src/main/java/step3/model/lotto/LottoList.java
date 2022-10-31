package step3.model.lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import step3.model.machine.Results;
import step3.view.OutputView;

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
