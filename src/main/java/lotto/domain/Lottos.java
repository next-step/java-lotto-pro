package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos fromQuantity(int quantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return new Lottos(lottos);
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(Arrays.asList(lottos));
    }

    public int size() {
        return lottos.size();
    }

    public WinResults getWinResults(Lotto winNumber) {
        return WinResults.of(lottos, winNumber);
    }

    public void print() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
