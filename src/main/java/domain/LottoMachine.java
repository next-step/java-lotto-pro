package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<Lotto> issueLottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = price; i >= 1000; i -= 1000) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
