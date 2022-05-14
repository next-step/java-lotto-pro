package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        Collections.shuffle(numbers);
        for (int i=0; i<6; i++) {
            list.add(numbers.get(i));
        }
        Collections.sort(list);
        this.lottoNumber = list;
    }

    public void printLottoNumber() {
        System.out.println(lottoNumber.toString());
    }
}
