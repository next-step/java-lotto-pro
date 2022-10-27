package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public List<Lotto> generateLottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
