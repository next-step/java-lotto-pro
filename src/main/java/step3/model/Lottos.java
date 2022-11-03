package step3.model;

import java.util.List;
import java.util.Objects;

public class Lottos {
    // 일급 컬렉션은 다른 맴버 변수가 없음
    public List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottoList() {
        return lottos;
    }
}
