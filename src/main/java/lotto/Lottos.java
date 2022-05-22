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

    public void addLottos(List<Lotto> passiveLottos) {
        this.lottos.addAll(passiveLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> getRanks(WinningLotto winningLotto) {
        return this.lottos.stream().map(lotto -> lotto.getRank(winningLotto)).collect(Collectors.toList());
    }

}
