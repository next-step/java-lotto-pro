package step3.model;

import java.util.ArrayList;
import java.util.List;

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

    public Lotto getLottoByIndex(int index) {
        if (count() <= index) {
            throw new RuntimeException("해당 인덱스에 로또가 존재하지않습니다.");
        }

        return this.lottos.get(index);
    }
}
