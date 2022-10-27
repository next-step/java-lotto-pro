package step3;

import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    private Lottos() { }

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos generate(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public int getSize() {
        return lottoList.size();
    }
}
