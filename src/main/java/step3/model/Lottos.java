package step3.model;

import step3.service.LottoScoreType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        if (lotto == null) {
            return;
        }

        this.lottos.add(lotto);
    }

    public int count() {
        return lottos.size();
    }

    public void print(Consumer<String> consumer) {
        this.lottos.forEach(lotto ->
                consumer.accept(lotto.toString()));
    }

    public LottoResult calculate(Lotto winningLotto) {
        LottoResult lottoResult = new LottoResult();
        this.lottos.forEach(lotto -> calculate(winningLotto, lottoResult, lotto));

        return lottoResult;
    }

    private void calculate(Lotto winningLotto, LottoResult lottoResult, Lotto lotto) {
        int count = lotto.getMatchedCountComparedToLotto(winningLotto);
        lottoResult.addByLottoScoreType(LottoScoreType.getByScore(count));
    }
}
