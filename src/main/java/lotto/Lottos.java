package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(LottoMachine.getRandomNumbers()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> getRanks(Lotto winningLotto) {
        return this.lottos.stream().map(lotto -> Rank.from(lotto.getCount(winningLotto))).collect(Collectors.toList());
    }

}
