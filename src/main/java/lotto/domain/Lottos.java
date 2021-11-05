package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos implements Iterable<Lotto> {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return this.lottos;
    }

    public List<List<Integer>> extractLottoNumbers() {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.extractNumber();
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(lotto-> lotto.toString()).collect(Collectors.joining());
    }
}
