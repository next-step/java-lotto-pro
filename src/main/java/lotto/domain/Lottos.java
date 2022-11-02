package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void buyLottos(int count) {
        for(int i=0; i<count; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()
                    .stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList())));
        }
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public LottoResult getResult(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        lottos.forEach(lotto -> result.add(winningLotto.getRank(lotto)));

        return result;
    }
}
