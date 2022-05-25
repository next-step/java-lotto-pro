package lotto;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public void addLottos(Lottos manualLottos) {
        this.lottos.addAll(manualLottos.getLottos());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Rank> getRanks(WinningLotto winningLotto) {
        return this.lottos.stream().map(lotto -> lotto.getRank(winningLotto)).collect(toList());
    }

}
