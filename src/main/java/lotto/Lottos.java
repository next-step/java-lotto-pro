package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    List<Lotto> lottos;

    public Lottos(int paperCount) {
        lottos = new ArrayList<>();
        for (int i = 0; i < paperCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public void printLottos() {
        for (Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }

    public int getLottosSize() {
        return lottos.size();
    }
}