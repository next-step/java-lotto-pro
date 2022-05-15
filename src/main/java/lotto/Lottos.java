package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(LottoMachine.getRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
