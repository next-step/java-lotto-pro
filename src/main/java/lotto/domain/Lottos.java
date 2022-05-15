package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(int count) {
        List<Lotto> list = new ArrayList<>();
        List<Integer> numbers = generateNumbers();
        for (int i=0; i<count; i++) {
            list.add(new Lotto(numbers));
        }
        this.lottoList = list;
    }

    private List<Integer> generateNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i=1; i<=45; i++) {
            list.add(i);
        }
        return list;
    }

    public void printLottoList() {
        for (Lotto n : this.lottoList) {
            n.printLottoNumber();
        }
    }
}
